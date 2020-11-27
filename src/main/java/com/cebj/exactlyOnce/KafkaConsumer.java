package com.cebj.exactlyOnce;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumer {
    public static void main(String[] args) {
        Properties props = setProps();
        org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(props);
        consumer.subscribe(Collections.singleton("std_topic"));
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("+++++++++++++++++++++++");
                System.out.println("key: " + record.key());
                System.out.println("value: " + record.value());
                System.out.println("offset: " + record.offset());
            }
        }
    }

    private static Properties setProps() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "nn1.hadoop:9092,nn2.hadoop:9092,s1.hadoop:9092");
        props.setProperty("auto.offset.reset", "latest");
        props.setProperty("group.id", "std_topic_001");
//        props.setProperty("isolation.level", "read_committed");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return props;
    }
}
