package com.cebj.flinknew.tableAPI;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.DataTypes;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import org.apache.flink.table.descriptors.Avro;
import org.apache.flink.table.descriptors.Kafka;
import org.apache.flink.table.descriptors.Schema;

public class TableApiKafka {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings =
                EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build();
        StreamTableEnvironment tableEnv = StreamTableEnvironment.create(env, settings);

        tableEnv
                .connect(new Kafka()
                        .version("0.11")
                        .topic("test_sensor")
                        .property("bootstrap.servers", "localhost:9092")
                )
                .withFormat(new Avro().avroSchema(""))
                .withSchema(new Schema()
                            .field("id", DataTypes.STRING())
                )
                .createTemporaryTable("inputTable");
    }
}
