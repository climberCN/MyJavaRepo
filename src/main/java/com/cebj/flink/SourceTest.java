package com.cebj.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.ArrayList;
import java.util.List;

public class SourceTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        // 从集合中读取数据，其实相当于从内存中读取数据，所以使用fromCollection()从当前集合中读取数据

        // 首先构建数据集合
        List<SensorRecord> records = new ArrayList<SensorRecord>(){
            {
                add(new SensorRecord("sensor_1", 1547718199L, 35.8));
                add(new SensorRecord("sensor_6", 1547718201L, 15.4));
                add(new SensorRecord("sensor_7", 1547718202L, 6.7));
                add(new SensorRecord("sensor_10", 1547718205L, 38.1));
            }
        };

        // 使用fromCollection(List)来从内存中读取数据
        DataStream<SensorRecord> stream1 = env.fromCollection(records);

        // 打印输出，这里没有任何的transformation，直接就打印到桌面了。这里print()是一个特殊的sink
        stream1.print("stream1");
        env.execute("source test job");
    }
}