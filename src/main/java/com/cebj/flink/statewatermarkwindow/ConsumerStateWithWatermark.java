package com.cebj.flink.statewatermarkwindow;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class ConsumerStateWithWatermark {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        DataStreamSource<String> stream = env.addSource(getConsumer(initConsumerConf()));


        Properties producerConfig = new Properties();
        producerConfig.setProperty("bootstrap.servers", "nn1.hadoop:9092");

        FlinkKafkaProducer<String> flinkKafkaProducer =
                new FlinkKafkaProducer<String>(
                        "flink_kafka_output",
                        new MapSerialization(),
                        producerConfig
                );
        stream.addSink(flinkKafkaProducer);

        env.execute();
    }

    private static FlinkKafkaConsumer<String> getConsumer(Properties consumerProps) {
        return new FlinkKafkaConsumer(
                "flink_kafka_input",
                new SimpleStringSchema(),
                initConsumerConf());
    }

    private static Properties initConsumerConf() {
        Properties consumerConfig = new Properties();
        consumerConfig.setProperty("bootstrap.servers", "nn1.hadoop:9092");
        consumerConfig.setProperty("group.id", "flink_consumer_1");
        return consumerConfig;
    }
}

class MapSerialization implements SerializationSchema<String> {
    @Override
    public byte[] serialize(String element) {
        return element.getBytes();
    }
}
