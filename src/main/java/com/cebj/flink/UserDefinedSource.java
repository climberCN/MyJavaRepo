package com.cebj.flink;

import org.apache.flink.streaming.api.functions.source.RichParallelSourceFunction;

import java.util.Random;

public class UserDefinedSource extends RichParallelSourceFunction {
    // 怎样控制该run时候run，该cancel时候cancel呢？
    // 定义一个标志位flag，来表示source是否正常运行
    Boolean running = true;


    // -----------------------------------------------------
    // 启动数据源
    // -----------------------------------------------------
    @Override
    public void run(SourceContext ctx) throws Exception {
        // run()方法通过什么不停地生成数据呢？这里ctx是上下文，通过上下文来发出我们当前要去做流式处理的数据
        // 一般情况下，就是从外部把数据读进来，然后通过上下文把数据发出去的
        // 现在我们不从外部读，直接在内部随机生成再发出去
        // 随机生成SensorReading数据
        running = true;
        Random random = new Random();
        while(running) {
            ctx.collect("test");
            Thread.sleep(1000);
        }
    }

    // -----------------------------------------------------
    // 停止数据源的运行
    // -----------------------------------------------------
    @Override
    public void cancel() {
        // flink去取消一个Job的时候，其实就是调用了SourceFunction里的cancel()方法
        // 那cancel()又是怎么控制不去读取数据了呢？
        running = false;
    }
}
