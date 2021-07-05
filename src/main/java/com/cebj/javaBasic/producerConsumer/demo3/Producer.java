package com.cebj.javaBasic.producerConsumer.demo3;

import java.util.Queue;
import java.util.Scanner;

public class Producer<T> implements Runnable{

    private Queue<T> tasks;
    private int tasksMaxCount;
    private Scanner scanner;

    public Producer(Queue<T> tasks, int tasksMaxCount) {
        this.tasks = tasks;
        this.tasksMaxCount = tasksMaxCount;
        scanner = new Scanner(System.in);
    }

    private T produce() {
        System.out.println("请输入字符串：");
        return (T)scanner.nextLine();
    }

    @Override
    public void run() {
        synchronized (tasks) {
            while (true) {
                try {
                    while (tasks.size() >= tasksMaxCount) {
                        tasks.wait();
                    }
                    tasks.add(produce());
                    tasks.notifyAll();
                    tasks.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
