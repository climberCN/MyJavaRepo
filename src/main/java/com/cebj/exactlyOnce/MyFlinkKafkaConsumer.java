package com.cebj.exactlyOnce;

import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class MyFlinkKafkaConsumer {
    private Properties prop;
    private String inTopic;
    private String consumerId = "ty_topic_001";

    public MyFlinkKafkaConsumer(String inTopic) {
        this.inTopic = inTopic;
        initProp();
    }

    public FlinkKafkaConsumer<String> initFlinkKafkaConsumer() {
        FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<>(inTopic, new SimpleStringSchema(), prop);
//        consumer.setCommitOffsetsOnCheckpoints(false);
//        consumer.setStartFromLatest();
        consumer.setStartFromGroupOffsets();
        return consumer;
    }

    private void initProp() {
        prop = new Properties();
        prop.setProperty("bootstrap.servers", "nn1.hadoop:9092,nn2.hadoop:9092,s1.hadoop:9092");
        prop.setProperty("group.id", consumerId);
//        prop.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        prop.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }
}
