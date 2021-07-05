package com.cebj.javaBasic.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerAppMain {

    public static final Object LOCKER = new Object();

    public static void main(String[] args) {
        Queue<String> urls = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(urls);
        Producer<String> producer = new Producer<>(urls, 1024);
        for (int i = 0; i < 100; i++) {
            Thread consumerThread = new Thread(
                    () -> {
                        while (true) {
                            try {
                                String url = consumer.consume();
                                processUrl(url);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
            , "消费者-" + i);
            consumerThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = produceUrl();
                        producer.produce(url);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "生产者-" + i);
            producerThread.start();
        }
        // 如果想给生产者消费做一个统计，统计每个生产者消费者所生产/消费的task数量，应该
        // 1.使用哪种数据结构
        // 2.如何保证线程安全
        // 3.怎么将统计结果输出到控制台？
    }

    private static String produceUrl() {
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = ((int) (Math.random() * 1000) % 26);
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processUrl(String url) throws InterruptedException {
        System.out.println("开始处理：" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理完成：" + url);
    }
}
