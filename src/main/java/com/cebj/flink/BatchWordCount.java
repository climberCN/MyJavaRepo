package com.cebj.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.MapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class BatchWordCount {
    public static void main(String[] args) throws Exception{
        // 获取一个批处理执行环境
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<String> text = env.readTextFile("D:\\IdeaProjects\\flinkoperator\\src\\main\\resources\\file1.txt");
        FlatMapOperator<String, String> op1 = text.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public void flatMap(String s, Collector<String> collector) throws Exception {
                String[] array = s.split(" ");
                for (String s1 : array) {
                    collector.collect(s1);
                }
            }
        });
        MapOperator<String, Tuple2<String, Integer>> op2 = op1.map(new MapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> map(String value) throws Exception {
                return new Tuple2<String, Integer>(value, 1);
            }
        });

        UnsortedGrouping<Tuple2<String, Integer>> op3 = op2.groupBy(0);

        op3.sum(1).print();
//        env.execute();
    }
}
