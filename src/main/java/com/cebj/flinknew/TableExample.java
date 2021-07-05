package com.cebj.flinknew;

import com.cebj.flink.demo.SensorRecord;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.streaming.api.scala.DataStream;
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;
import scala.Array;

public class TableExample {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStream<String> inputStream = env.readTextFile("D:\\IdeaProjects\\MyJavaRepo\\src\\main\\resources\\file1.txt");
//        DataStream<SensorRecord> dataStream = inputStream.map(new MyMapFunction());

//        StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(env);
    }

    public static class MyMapFunction extends RichMapFunction<String, SensorRecord> {
        @Override
        public SensorRecord map(String value) throws Exception {
            String[] data = value.split(",");
            return new SensorRecord(data[0], Long.valueOf(data[1]), Double.valueOf(data[2]));
        }
    }
}


