package com.cebj.flinknew.tableAPI;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.FileSystem;
import org.apache.flink.table.descriptors.OldCsv;
import org.apache.flink.table.descriptors.Schema;
import org.apache.flink.types.Row;

public class TableTest4 {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings =
                EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);

        String path = "D:\\IdeaProjects\\MyJavaRepo\\src\\main\\resources\\file1.txt";
        tableEnv
                .connect(new FileSystem().path(path))
                .withFormat(new OldCsv())
                .withSchema(new Schema()    // 定义表结构
                        .field("id", DataTypes.STRING())
                        .field("timestamp", DataTypes.BIGINT())
                        .field("temperature", DataTypes.DOUBLE())
                )
                .createTemporaryTable("inputTable");
        Table table = tableEnv.sqlQuery("SELECT id, temperature FROM inputTable WHERE id='sensor_1'");
        DataStream<Row> retStream = tableEnv.toAppendStream(table, Row.class);
        retStream.print();
        env.execute("table test");
    }
}
