package com.cebj.flinknew.tableAPI;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.Csv;
import org.apache.flink.table.descriptors.Kafka;
import org.apache.flink.table.descriptors.Schema;
import org.apache.flink.types.Row;

import static org.apache.flink.table.api.Expressions.$;

public class TableApiKafka {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        EnvironmentSettings settings =
                EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);

        tableEnv.executeSql("CREATE TABLE inputTable (\n" +
                "  `id` STRING,\n" +
                "  `timestamp` BIGINT,\n" +
                "  `temperature` DOUBLE\n" +
                ") WITH (\n" +
                "  'connector' = 'kafka',\n" +
                "  'topic' = 'hainiu_test',\n" +
                "  'properties.bootstrap.servers' = 'nn1.hadoop:9092',\n" +
                "  'properties.group.id' = 'testzjh',\n" +
                "  'value.format' = 'csv'\n" +
                ")");
        tableEnv.executeSql("CREATE TABLE outTable (\n" +
                "  `id` STRING,\n" +
                "  `id_count` BIGINT,\n" +
                "  PRIMARY KEY (`id`) NOT ENFORCED\n" +
                ") WITH (\n" +
                "  'connector' = 'upsert-kafka',\n" +
                "  'topic' = 'transactions',\n" +
                "  'properties.bootstrap.servers' = 'nn1.hadoop:9092',\n" +
                "  'properties.group.id' = 'testzjh',\n" +
                "  'key.format' = 'csv',\n" +
                "  'value.format' = 'csv'\n" +
                ")");

        Table inputTable = tableEnv.from("inputTable");
        Table retTable = inputTable
                .groupBy($("id"))
                .select($("id"), $("id").count().as("count"));
        retTable.executeInsert("outTable");
    }
}
