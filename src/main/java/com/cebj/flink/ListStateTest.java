package com.cebj.flink;

import org.apache.flink.api.common.functions.RichFilterFunction;
import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.state.MapState;
import org.apache.flink.api.common.state.MapStateDescriptor;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ListStateTest {
    public static void main(String[] args) {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        DataStreamSource<String> intputStream = env.socketTextStream("nn1.hadoop", 9999);
        SingleOutputStreamOperator<SensorRecord> sensorStream = intputStream.map(str -> new SensorRecord(
                str.split(",")[0],
                Long.valueOf(str.split(",")[1]),
                Double.valueOf(str.split(",")[2]))
        );
        KeyedStream<String, Tuple> keyedStream = intputStream.keyBy("id");
    }

    private static class MyFilterFunction extends RichFilterFunction<SensorRecord> {
        private transient ListState<Long> listState;
        private transient MapState<String, Long> mapState;

        @Override
        public void open(Configuration parameters) throws Exception {
            super.open(parameters);
            ListStateDescriptor<Long> listStateDescriptor = new ListStateDescriptor<>("listState", Types.LONG);
            listState = getRuntimeContext().getListState(listStateDescriptor);

            MapStateDescriptor<String, Long> mapStateDescriptor =
                    new MapStateDescriptor<String, Long>("mapState", Types.STRING, Types.LONG);
            mapState = getRuntimeContext().getMapState(mapStateDescriptor);

        }

        @Override
        public boolean filter(SensorRecord value) throws Exception {
//            listState.addAll();
//            listState.add();
//            listState.update();
//            listState.clear();
//            listState.get();
//
//
//            mapState.contains();
//            mapState.entries();
//            mapState.get();
//            mapState.isEmpty();
//            mapState.iterator();
//            mapState.keys();
//            mapState.put();
//            mapState.putAll();
//            mapState.remove();
            return true;
        }
    }
}
