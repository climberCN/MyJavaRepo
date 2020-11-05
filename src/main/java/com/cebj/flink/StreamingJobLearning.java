package com.cebj.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class StreamingJobLearning {
    public static void main(String[] args) {
        // 创建流式程序的Enviroment。创建执行环境直接就getExecutionEnviroment()了。但是大家有没有怀疑，
        // 我这里边创建这个执行环境的时候，我在IDE里穿件的执行环境和我最后打包提交部署到集群环境的执行环境
        // 难道是一样的吗？
        // 执行环境，我们执行程序是在TaskManager，但是TM得和JM交互。
        // 所以这里我们并没有做特别的配置，难道说开发环境和最后的执行环境是一模一样的吗？当然不是
        // 其实是flink帮我们把底层的东西隐藏起来了。
        // 底层是什么呢？如果是在IDE里面执行，其实是执行的createLocalEnviroment()
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 设置环境的并行度，设置为1，那么输出没有小符号，且不会乱序
        env.setParallelism(1);
    }
}