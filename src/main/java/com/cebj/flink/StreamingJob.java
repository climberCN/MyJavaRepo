package com.cebj.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.*;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;

public class StreamingJob {
    public static void main(String[] args) throws Exception {
        // set up the streaming execution environment
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> socketText = env.socketTextStream("nn1.hadoop", 9999, "\n");
        SingleOutputStreamOperator<String> flatmap = socketText.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] splits = s.split("\\s");
                for (String str : splits) {
                    collector.collect(str);
                }
            }
        });
        SingleOutputStreamOperator<Tuple2<String, Integer>> map = flatmap.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String value) throws Exception {
                return new Tuple2<String, Integer>(value, 1);
            }
        });
        KeyedStream<Tuple2<String, Integer>, Tuple> keyby = map.keyBy(0);
        SingleOutputStreamOperator<Tuple2<String, Integer>> count = keyby.sum(1);
        count.print().setParallelism(1);
        // execute program， DataStream需要执行env.execute()，如果是DataSet的ExecutionEnviroment env = ...，就不需要env.execute()。
        env.execute("Socket window wordcount");
    }

}
