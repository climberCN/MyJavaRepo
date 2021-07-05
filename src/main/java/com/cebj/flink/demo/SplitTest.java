package com.cebj.flink.demo;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;

public class SplitTest {
//    public static void main(String[] args) throws Exception {
//        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(1);
//
//        DataStreamSource<String> inputStream = env.readTextFile("src/main/resources/file1.txt");
//        SingleOutputStreamOperator<SensorRecord> sensorStream = inputStream.map(new MyMapFunction());
//        SplitStream<SensorRecord> splitStream = sensorStream.split(new MySplitFunction());
//        DataStream<SensorRecord> bigStream = splitStream.select("big");
//        DataStream<SensorRecord> smallStream = splitStream.select("small");
//        env.execute();
//    }
//
//    private static class MyMapFunction extends RichMapFunction<String, SensorRecord> {
//
//        @Override
//        public SensorRecord map(String value) throws Exception {
//            String[] fields = value.split(",");
//            return new SensorRecord(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
//        }
//    }
//
//    private static class MySplitFunction implements OutputSelector<SensorRecord> {
//
//        @Override
//        public Iterable<String> select(SensorRecord value) {
//            ArrayList<String> flags = new ArrayList<String>();
//            if (value.getTimestamp() > 10) {
//                flags.add("big");
//            } else {
//                flags.add("small");
//            }
//            return flags;
//        }
//    }
}
