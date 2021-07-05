package com.cebj.javaBasic.producerConsumer.demo3;

import java.util.LinkedList;
import java.util.Queue;

public class AppMain {
    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();
        Thread conusmer = new Thread(new Consumer<String>(tasks), "conusmer");
        Thread producer =
                new Thread(new Producer<String>(tasks, 1024), "producer");
        conusmer.start();
        producer.start();
    }
}
