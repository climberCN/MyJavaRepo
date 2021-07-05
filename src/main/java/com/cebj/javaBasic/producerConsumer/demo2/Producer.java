package com.cebj.javaBasic.producerConsumer.demo2;

import java.util.Queue;
import java.util.Scanner;

public class Producer<T> {

    private Queue<T> tasks;
    private int tasksMaxCount;
    private Scanner scanner;

    public Producer(Queue<T> tasks, int tasksMaxCount) {
        this.tasks = tasks;
        this.tasksMaxCount = tasksMaxCount;
        scanner = new Scanner(System.in);
    }

    public void put() throws InterruptedException {
        synchronized (tasks) {
            if (tasks.size() >= tasksMaxCount) {
                tasks.wait();
            }
            tasks.add(produce());
            tasks.notifyAll();
        }
    }

    private T produce() {
        System.out.println("请输入字符串：");
        return (T)scanner.nextLine();
    }
}
