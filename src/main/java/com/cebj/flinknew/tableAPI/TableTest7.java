package com.cebj.flinknew.tableAPI;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.FileSystem;
import org.apache.flink.table.descriptors.OldCsv;
import org.apache.flink.table.descriptors.Schema;

import static org.apache.flink.table.api.Expressions.$;

public class TableTest7 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        EnvironmentSettings settings =
                EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);

        String inputPath = "D:\\IdeaProjects\\flinkoperator\\src\\main\\resources\\file1.txt";
        String outputPath = "D:\\IdeaProjects\\flinkoperator\\src\\main\\resources\\out.txt";
        tableEnv
                .connect(new FileSystem().path(inputPath))
                .withFormat(new OldCsv())
                .withSchema(new Schema()    // 定义表结构
                        .field("id", DataTypes.STRING())
                        .field("timestamp", DataTypes.BIGINT())
                        .field("temperature", DataTypes.DOUBLE())
                )
                .createTemporaryTable("inputTable");

        tableEnv
                .connect(new FileSystem().path(outputPath))
                .withFormat(new OldCsv())
                .withSchema(new Schema()
                        .field("id", DataTypes.STRING())
                        .field("count", DataTypes.BIGINT())
                )
                .inRetractMode()
                .createTemporaryTable("outputTable");

        Table inputTable = tableEnv.from("inputTable");
        Table retTable = inputTable
                .groupBy($("id"))
                .select($("id"), $("id").count().as("count"));
        retTable.executeInsert("outputTable");
        tableEnv.execute("test");
    }
}
