package com.cebj.flink;

import org.apache.flink.api.common.functions.RichFilterFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StateTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> input = env.socketTextStream("nn1.hadoop", 9999);
        SingleOutputStreamOperator<SensorRecord> sensorStream = input.map(str -> new SensorRecord(
                str.split(",")[0],
                Long.valueOf(str.split(",")[1]),
                Double.valueOf(str.split(",")[2]))
        );
        SingleOutputStreamOperator<SensorRecord> filterStream = sensorStream.filter(new MyFilterFunction());
        filterStream.print();

        env.execute("state test job");
    }

    private static class MyFilterFunction extends RichFilterFunction<SensorRecord> {
        // 这里使用transient关键字的作用是在该对象在序列化的时候，flagState不会被序列化
        // 一般把状态定义成XXXFunction的属性，这样我们就可以在open()函数中注册该状态
        // 并在filter()这样的用户自定义函数中使用
        private transient ValueState<Boolean> flagState;

        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
            // 我们要使用flink的状态管理机制，就需要按照flink的接口去使用。
            // flink需要知道我们State的类型，那么就需要使用到ValueStateDescriptor这个类来对值状态进行描述。
            // 有了这个描述器，使用RuntimeContext#getState(Descriptor)来向flink注册状态。
            ValueStateDescriptor<Boolean> flagDescripter = new ValueStateDescriptor<Boolean>("flag", Types.BOOLEAN);
            flagState = getRuntimeContext().getState(flagDescripter);
        }

        @Override
        public boolean filter(SensorRecord value) throws Exception {
            // 读取状态
            Boolean flag = flagState.value();
            // 对状态赋值
            flagState.update(true);
            return true;
        }
    }
}
