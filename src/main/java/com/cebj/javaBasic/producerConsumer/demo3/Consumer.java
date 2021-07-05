package com.cebj.javaBasic.producerConsumer.demo3;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class Consumer<T> implements Runnable{
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    private void process(T task) throws InterruptedException {
        System.out.println("开始处理...");
        System.out.println("输入的字符串为：" + task);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("处理结束...");
        System.out.println();
    }

    @Override
    public void run() {
        synchronized (tasks) {
            // 这里的while和synchronized换换位置有什么差别吗？
            while (true) {
                try {
                    while (tasks.size() == 0) {
                        tasks.wait();
                    }
                    process(tasks.poll());
                    tasks.notifyAll();
                    tasks.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
