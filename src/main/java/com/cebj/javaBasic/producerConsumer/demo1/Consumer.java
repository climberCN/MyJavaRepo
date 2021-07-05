package com.cebj.javaBasic.producerConsumer.demo1;

import java.util.List;

public class Consumer implements Runnable{
    private final Object locker;
    private final List<String> data;
    private int offset;

    public Consumer(Object locker, List<String> data) {
        this.locker = locker;
        this.data = data;
        offset = 0;
    }

    @Override
    public void run() {
        while (true) {
            consume();
        }
    }

    private void consume() {
        synchronized (locker) {
            try {
                locker.wait();
                while (offset < data.size()) {
                    System.out.println("消费到的数据为：index=" + offset + "; data=" + data.get(offset));
                    offset++;
                    locker.notify();
                    locker.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
