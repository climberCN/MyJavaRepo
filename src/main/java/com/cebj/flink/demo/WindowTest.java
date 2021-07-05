package com.cebj.flink.demo;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.functions.RuntimeContext;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;

public class WindowTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        DataStreamSource<String> inputStream = env.readTextFile("src/main/resources/file1.txt");
        SingleOutputStreamOperator<SensorRecord> sensorStream = inputStream.map(new MyMapFunction());
        KeyedStream<SensorRecord, Tuple> keyedStream = sensorStream.keyBy("id");
        WindowedStream<SensorRecord, Tuple, TimeWindow> window = keyedStream.window(EventTimeSessionWindows.withGap(Time.seconds(1)));
        SingleOutputStreamOperator<SensorRecord> temperature = window.allowedLateness(Time.seconds(2)).sum("temperature");
//        temperature.assignTimestampsAndWatermarks()
        temperature.print();

        env.execute();
    }

    private static class MyMapFunction extends RichMapFunction<String, SensorRecord> {
        @Override
        public SensorRecord map(String value) throws Exception {
            String[] fields = value.split(",");
            RuntimeContext runtimeContext = super.getRuntimeContext();
            return new SensorRecord(fields[0], Long.valueOf(fields[1]), Double.valueOf(fields[2]));
        }
    }
}
