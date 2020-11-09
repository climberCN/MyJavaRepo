package com.cebj.exactlyOnce;

import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.connectors.kafka.KafkaSerializationSchema;
import org.apache.kafka.clients.producer.ProducerRecord;

import javax.annotation.Nullable;
import java.util.Properties;

public class MyFlinkKafkaProducer {
    private static String outTopic;
    private Properties props;
    private KafkaSerializationSchema serializationSchema;

    public MyFlinkKafkaProducer(String outTopic) {
        this.outTopic = outTopic;
        initProps();
        initSerializationSchema();

    }

    public FlinkKafkaProducer<String> initFlinkKafkaProducer() {
        FlinkKafkaProducer<String> producer = new FlinkKafkaProducer<String>(
                outTopic,
                serializationSchema,
                props,
                FlinkKafkaProducer.Semantic.EXACTLY_ONCE);
        return producer;
    }

    private void initProps() {
        props = new Properties();
        props.setProperty("bootstrap.servers", "nn1.hadoop:9092,nn2.hadoop:9092,s1.hadoop:9092");
    }

    private void initSerializationSchema() {
        serializationSchema = new MySerializationSchema();
    }

    private static class MySerializationSchema implements KafkaSerializationSchema<String> {
        @Override
        public ProducerRecord<byte[], byte[]> serialize(String element, @Nullable Long timestamp) {
            return new ProducerRecord<byte[], byte[]>(outTopic, ("index:" + element).getBytes(), element.getBytes());
        }
    }
}
