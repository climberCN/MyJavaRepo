package com.cebj.exactlyOnce;

import org.apache.flink.runtime.state.filesystem.FsStateBackend;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkJob {
    private static String inTopic = "ty_topic";
    private static String outTopic = "std_topic";

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        env.setStateBackend(new FsStateBackend("file:///data/flink/checkpoints1"));
        env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
        env.enableCheckpointing(60000);

        DataStreamSource<String> source = env.addSource(new MyFlinkKafkaConsumer(inTopic).initFlinkKafkaConsumer());
        source.addSink(new MyFlinkKafkaProducer(outTopic).initFlinkKafkaProducer());

        env.execute("exactly_once_test");
    }
}
