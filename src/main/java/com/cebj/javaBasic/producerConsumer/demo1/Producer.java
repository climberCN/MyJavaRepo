package com.cebj.javaBasic.producerConsumer.demo1;

import java.util.List;
import java.util.Scanner;

public class Producer implements Runnable {
    private final Object locker;
    private final Consumer consumer;
    private final List<String> data;

    public Producer(Object locker, Consumer consumer, List<String> data) {
        this.locker = locker;
        this.consumer = consumer;
        this.data = data;
    }

    @Override
    public void run() {
        produce();
    }

    // 这里的功能拆分的不够，制造数据和将数据放入队列可以拆分成两个功能
    private void produce() {
        Scanner scanner = new Scanner(System.in);
        String tmp;
        synchronized (locker) {
            System.out.println("输入数据(stop退出)：");
            while (!"stop".equals(tmp = scanner.nextLine())) {
                System.out.println("输入数据(stop退出)：");
                try {
                    data.add(tmp);
                    locker.notify();
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
