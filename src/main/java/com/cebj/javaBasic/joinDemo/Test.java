package com.cebj.javaBasic.joinDemo;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    private static List<String> CONTENTS = new ArrayList<>();
    private static List<Thread> threads = new ArrayList<>();
    private static long ThreadsWorkDuration = 0;

    public static void main(String[] args) throws InterruptedException {
        long mainStart = System.currentTimeMillis();
        System.out.println(getName() + "开始执行...");
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                long start = System.currentTimeMillis();
                System.out.println(getName() + "线程开始爬取网页");
                String ret = getContentFromWeb();
                synchronized (threads) {
                    CONTENTS.add(ret);
                    ThreadsWorkDuration += System.currentTimeMillis() - start;
                }
            }, "线程-" + i);
            thread.start();
            threads.add(thread);
        }

        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        threads.forEach((s) -> {
            try {
                System.out.println(getName() + "join了" + s.getName());
                s.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(getName() + "join()后，接收到Interrupt信号", e);
            }
        });

        CONTENTS.forEach((s) -> {
            System.out.println(s.length() + ": ");
            System.out.println(s);
        });

        System.out.println("worker线程总工作时长：" + ThreadsWorkDuration);
        System.out.println("main线程总工作时长：" + (System.currentTimeMillis() - mainStart));
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }

    private static String getContentFromWeb() {
        StringBuilder ret = new StringBuilder();
        int len = ((int) (Math.random() * 1000000)) % 4096 + 1024;
        for (int i = 0; i < len; i++) {
            int rand = ((int) (Math.random() * 1000)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}
