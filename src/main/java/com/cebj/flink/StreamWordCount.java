package com.cebj.flink;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.datastream.WindowedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class StreamWordCount {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);

        DataStreamSource<String> inputStream = env.socketTextStream("nn1.hadoop", 9999);
        SingleOutputStreamOperator<String> wordsStream = inputStream.flatMap(new MyFlatMapFunction());
        SingleOutputStreamOperator<Tuple2<String, Integer>> wordOneStream = wordsStream.map(new MyMapFunction());
        KeyedStream<Tuple2<String, Integer>, Tuple> keyedStream = wordOneStream.keyBy(0);
        WindowedStream<Tuple2<String, Integer>, Tuple, TimeWindow> keyedTimeWindowWindowedStream = keyedStream.timeWindow(Time.seconds(2));
        SingleOutputStreamOperator<Tuple2<String, Integer>> wordcountStream = keyedTimeWindowWindowedStream.sum(1);
        wordcountStream.print();
        env.execute("streamWordCount");
    }

    private static class MyFlatMapFunction extends RichFlatMapFunction<String, String> {
        @Override
        public void flatMap(String value, Collector<String> out) throws Exception {
            String[] words = value.split(" ");
            for (String word : words) {
                out.collect(word);
            }
        }
    }

    private static class MyMapFunction extends RichMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public Tuple2<String, Integer> map(String value) throws Exception {
            return new Tuple2(value, 1);
        }
    }
}
