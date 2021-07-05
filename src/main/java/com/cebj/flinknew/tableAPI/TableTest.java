package com.cebj.flinknew.tableAPI;

import com.cebj.flink.demo.SensorRecord;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.types.Row;

public class TableTest {
    private static String dataPath = "D:\\IdeaProjects\\flinkoperator\\src\\main\\resources\\file1.txt";

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
        Table table = tableEnv.fromDataStream(dataStream);
        table.printSchema();
        Table retTable = table.select("id, temperature").filter("id == 'sensor_1'");
        // 直接写SQL得到转换结果,table变量是我们自己定义的表变量，但是并不是TableEnv里面定义的表。
        // tableEnv.sqlQuery()中定义的SQL语句用到的表名需要在tableEnv中注册。
//        Table retTable1 = tableEnv.sqlQuery("SELECT id, temperature FROM " + table + "WHERE id='sensor_1'");

        retTable.printSchema();
        DataStream<Row> retStream = tableEnv.toAppendStream(retTable, Row.class);
        retStream.print();
        env.execute("table example test");
    }
}
