package com.cebj.flink;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class UserDefinedSourceTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(3);

        DataStreamSource dataStreamSource = env.addSource(new UserDefinedSource());
//        dataStreamSource.map()
        SingleOutputStreamOperator returns = dataStreamSource.returns(TypeInformation.of(new TypeHint<String>() {
        }));
        returns.print();

        env.execute();
    }
}
