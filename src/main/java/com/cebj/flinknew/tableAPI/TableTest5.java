package com.cebj.flinknew.tableAPI;

import com.cebj.flink.demo.SensorRecord;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.FileSystem;
import org.apache.flink.table.descriptors.OldCsv;
import org.apache.flink.table.descriptors.Schema;
import org.apache.flink.types.Row;

import static org.apache.flink.table.api.Expressions.$;

public class TableTest5 {
    private static String dataPath = "D:\\IdeaProjects\\MyJavaRepo\\src\\main\\resources\\file1.txt";

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> inputStream = env.readTextFile(dataPath);
        DataStream<SensorRecord> dataStream = inputStream.map(new MapFunction<String, SensorRecord>() {
            @Override
            public SensorRecord map(String value) throws Exception {
                String[] data = value.split(",");
                return new SensorRecord(data[0], Long.valueOf(data[1]), Double.valueOf(data[2]));
            }
        });
        EnvironmentSettings settings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);
        Table table = tableEnv.fromDataStream(dataStream, $("temperature").as("tp"), $("id"));
        DataStream<Row> retStream = tableEnv.toAppendStream(table, Row.class);
        table.printSchema();
        retStream.print();
        env.execute("test");
    }
}
