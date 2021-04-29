package com.cebj.flinknew;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;
import org.apache.flink.streaming.connectors.kafka.internals.KeyedSerializationSchemaWrapper;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class FlinkTestOneToOne {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    FlinkKafkaConsumer<String> consumer =
        new FlinkKafkaConsumer<>("ty_topic", new SimpleStringSchema(), getConsumerProp());
    DataStreamSource<String> source = env.addSource(consumer);
    FlinkKafkaProducer producer =
        new FlinkKafkaProducer<>(
            "std_topic",
            new KeyedSerializationSchemaWrapper(new SimpleStringSchema()),
            getProducerProp(),
            FlinkKafkaProducer.Semantic.EXACTLY_ONCE);
    DataStreamSink sink = source.addSink(producer);
    env.execute("one-to-one");
  }

  private static Properties getConsumerProp() {
    Properties prop = new Properties();
    prop.setProperty("bootstrap.servers", "nn1.hadoop:9092,nn2.hadoop:9092,s1.hadoop:9092");
    prop.setProperty("auto.offset.reset", "latest");
    prop.setProperty("group.id", "std_topic_001");
    prop.setProperty("enable.auto.commit", "true");
    prop.setProperty("auto.commit.interval.ms", "1000");
    prop.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    prop.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    return prop;
  }

  private static Properties getProducerProp() {
    Properties prop = new Properties();
    prop.put("bootstrap.servers", "nn1.hadoop:9092,nn2.hadoop:9092,s1.hadoop:9092");
    prop.put("key.serializer", StringSerializer.class.getName());
    prop.put("value.serializer", StringSerializer.class.getName());
    return prop;
  }

  private class MyMap extends RichMapFunction<String, String> {
    @Override
    public String map(String value) throws Exception {

      return null;
    }
  }
}
