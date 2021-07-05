package com.cebj.javaBasic.producerConsumer;

import java.util.Queue;

public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            // 如果不用while用if，会怎么样？
            while (tasks.size() == 0) {
                System.out.println("消费者线程进入等待： " + Thread.currentThread().getName());
                // wait方法会释放monitor
                tasks.wait();
            }
            T ret = tasks.poll();
            // 调用notify或者notifyALl的时候，必须已经获得对象的monitor，也就是在对象的synchronized块中
            tasks.notifyAll();
            return ret;
        }
    }
}
