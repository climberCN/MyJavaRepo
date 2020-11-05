package com.cebj.flink;


import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.sink.RichSinkFunction;

public class MySinkFunction extends RichSinkFunction {
    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
    }

    @Override
    public void invoke(Object value, Context context) throws Exception {
        SensorRecord result = (SensorRecord) value;
        System.out.println(result);
    }

    @Override
    public void close() throws Exception {
        super.close();
    }
}
