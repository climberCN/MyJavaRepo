package com.cebj.flink;

import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class SourceKafkaTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(4);

        // env并没有提供连接kafka的函数，flink内部没有提供连接kafka的组件。
        // 所以需要引入第三方的支持，引入别的依赖，所以使用的就是env.addSource()
        // 字面意思，添加一个source，这是flink给我们提供的基于执行环境的创建数据源的最一般化的方法
        // 不管是读什么样的源，用这个都可以实现。

        Properties consumerConfig = new Properties();
        consumerConfig.setProperty("bootstrap.servers", "nn1.hadoop:9092");
        consumerConfig.setProperty("group.id", "flink_consumer_1");

        FlinkKafkaConsumer<String> flinkKafkaConsumer =
                new FlinkKafkaConsumer<String>(
                        "flink_kafka_input",
                        new SimpleStringSchema(),
                        consumerConfig
                );

        DataStreamSource<String> stream = env.addSource(flinkKafkaConsumer);


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
}

class MapSerialization implements SerializationSchema<String> {
    @Override
    public byte[] serialize(String element) {
        return element.getBytes();
    }
}