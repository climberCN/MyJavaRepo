package com.cebj.flink;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class KeyByTest {
  public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.setParallelism(1);

    DataStreamSource<String> dataStream = env.readTextFile("src/main/resources/file1.txt");
    // map算子，将一行一行读入的String进行切分，转换成一个一个的SensorRecord对象
    SingleOutputStreamOperator<SensorRecord> sensorStream = dataStream.map(new TestMapFunction()).setParallelism(4);
    // 之后我们想让不同的数据进入不同的分区
    //        KeyedStream<SensorRecord, String> sensorRecordStringKeyedStream =
    // sensorStream.keyBy(new MySelector());
    KeyedStream<SensorRecord, Tuple> sensorRecordStringKeyedStream = sensorStream.keyBy("id");
    //        SingleOutputStreamOperator<SensorRecord> temperatureMax =
    // sensorRecordStringKeyedStream.maxBy("temperature");
    SingleOutputStreamOperator<SensorRecord> reduceStream =
        sensorRecordStringKeyedStream.reduce(new MyReduceFunction());
    reduceStream.print();
    System.out.println(env.getExecutionPlan());
    env.execute();
  }

  private static class TestMapFunction extends RichMapFunction<String, SensorRecord> {

    @Override
    public SensorRecord map(String value) throws Exception {
      String[] item = value.toString().split(",");
      return new SensorRecord(item[0], Long.valueOf(item[1]), Double.valueOf(item[2]));
    }
  }

  private static class MySelector implements KeySelector<SensorRecord, String> {
    @Override
    public String getKey(SensorRecord value) throws Exception {
      System.out.println();
      return value.getId();
    }
  }

  private static class MyReduceFunction implements ReduceFunction<SensorRecord> {

    @Override
    public SensorRecord reduce(SensorRecord value1, SensorRecord value2) throws Exception {
      Long maxTimestamp =
          value1.getTimestamp().compareTo(value2.getTimestamp()) > 0
              ? value1.getTimestamp()
              : value2.getTimestamp();
      Double minTemperature =
          value1.getTemperature().compareTo(value2.getTemperature()) < 0
              ? value1.getTemperature()
              : value2.getTemperature();
      return new SensorRecord(value1.getId(), maxTimestamp, minTemperature);
    }
  }
}
