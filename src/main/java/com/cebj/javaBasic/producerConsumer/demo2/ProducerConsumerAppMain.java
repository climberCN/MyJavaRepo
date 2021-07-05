package com.cebj.javaBasic.producerConsumer.demo2;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerAppMain {
    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();
        Consumer<String> consumer = new Consumer<>(tasks);
        Producer<String> producer = new Producer<>(tasks, 1024);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    producer.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"producer-" + i).start();
        }

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    consumer.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "consumer-" + i).start();
        }
    }
}
