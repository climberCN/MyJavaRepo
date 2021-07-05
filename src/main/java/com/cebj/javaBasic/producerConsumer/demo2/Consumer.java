package com.cebj.javaBasic.producerConsumer.demo2;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public void get() throws InterruptedException {
        synchronized (tasks) {
            if (tasks.size() == 0) {
                tasks.wait();
            }
            process(tasks.poll());
            tasks.notifyAll();
        }
    }

    private void process(T task) throws InterruptedException {
        System.out.println("开始处理...");
        System.out.println(task);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理结束...");
    }
}
