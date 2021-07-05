package com.cebj.flink.demo;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StateBackendTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);
        env.setStateBackend(new FsStateBackend("file:///checkpoints"));
        // 开启checkpoint，这里参数是毫秒，也就是说每个1000毫秒做一次checkpoint。即每隔1秒将内存状态存储到持久化存储中
        env.enableCheckpointing(1000);
        // 要对checkpoint进行配置，需要先获取到checkpoint，然后才会有设置checkpoint的方法setCheckpointMode()里边要传一个checkpoint模式
        // CheckpointingMode是一个枚举类型，这就是flink中的状态一致性语义。
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        // timeout是做一次checkpoint所用的最多时间，超过这个时间，这个checkpoint就丢掉，就当当前没保存好，这里指30秒必须做完一个checkpoint
        env.getCheckpointConfig().setCheckpointTimeout(30000L);
        // 同一时间进行的checkpoint，因为checkpoint有可能执行时间很长，那就有可能上一个checkpoint没做完，下一个checkpoint就开始了。
        // 所以就需要同时处理checkpoint。
        // 我们之前说配置同步checkpoint的话，那必须等到处理完后checkpoint，才能处理数据
        // 那么对于异步的checkpint,那么我们task什么时候可以去处理数据，它的标志是什么？是当前task对应的状态都保存到状态后端后，就可以继续处理下面的数据了。
        env.getCheckpointConfig().setMaxConcurrentCheckpoints(3);
        env.getCheckpointConfig().setMinPauseBetweenCheckpoints(500L);
        env.getCheckpointConfig().setPreferCheckpointForRecovery(false);
        env.getCheckpointConfig().setTolerableCheckpointFailureNumber(5);
        env.setRestartStrategy(RestartStrategies.fixedDelayRestart(10,1000L));

        DataStreamSource<String> intputStream = env.socketTextStream("nn1.hadoop", 9999);
        SingleOutputStreamOperator<SensorRecord> sensorStream = intputStream.map(str -> new SensorRecord(
                str.split(",")[0],
                Long.valueOf(str.split(",")[1]),
                Double.valueOf(str.split(",")[2]))
        );
        KeyedStream<SensorRecord, String> keyedStream = sensorStream.keyBy(new MySelector());
        SingleOutputStreamOperator<String> mapStream = keyedStream.map(new Alert());
        env.execute("StateTest");
    }

    private static class MySelector implements KeySelector<SensorRecord, String> {
        @Override
        public String getKey(SensorRecord value) throws Exception {
            return value.getId();
        }
    }

    private static class Alert extends RichMapFunction<SensorRecord, String> {
        private transient ValueState<Double> lastTeperature;

        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
            ValueStateDescriptor<Double> valueStateDescriptor = new ValueStateDescriptor<Double>("last-teperature", Types.DOUBLE);
            lastTeperature = getRuntimeContext().getState(valueStateDescriptor);
        }

        @Override
        public String map(SensorRecord value) throws Exception {
            if (null == lastTeperature.value()) {
                lastTeperature.update(value.getTemperature());
                return null;
            }
            if (Math.abs(lastTeperature.value() - value.getTemperature()) > 10) {
                System.out.println("警告：瞬时温差超过10度！！！");
            }
            lastTeperature.update(value.getTemperature());
            return null;
        }

        @Override
        public void close() throws Exception {
            super.close();
        }
    }
}
