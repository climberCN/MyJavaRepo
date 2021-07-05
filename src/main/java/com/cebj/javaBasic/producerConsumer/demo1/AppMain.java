package com.cebj.javaBasic.producerConsumer.demo1;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        Object locker = new Object();
        List<String> data = new ArrayList<>();
        Consumer cons = new Consumer(locker, data);
        Thread consumer = new Thread(cons, "consumer");
        Thread producer = new Thread(new Producer(locker, cons, data), "producer");
        producer.start();
        consumer.start();
    }
}
