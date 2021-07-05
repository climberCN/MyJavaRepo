package com.cebj.flink.demo;

import org.apache.avro.generic.GenericRecord;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.annotation.Nullable;
import java.util.Properties;

public class KafkaSinkTest {
    private static Properties prop;

    public static void main(String[] args) {
        prop = new Properties();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> inputStream = env.socketTextStream("nn1.hadoop", 9999);
//        inputStream.addSink(new FlinkKafkaProducer<GenericRecord>("topic1", new MyKafkaSink(), prop, FlinkKafkaProducer.Semantic.EXACTLY_ONCE))
    }

    private static class MyKafkaSink implements KafkaSerializationSchema<GenericRecord> {
        @Override
        public ProducerRecord<byte[], byte[]> serialize(GenericRecord element, @Nullable Long timestamp) {
            byte[] value = element.toString().getBytes();
            String key = String.valueOf(element.get("primary_key"));
            return new ProducerRecord<byte[], byte[]>(key, value);
        }
    }
}
