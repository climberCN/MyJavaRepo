package com.cebj.javaBasic.learnThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterruptThreadAppMain1 {

    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始，执行的线程名字叫做" + Thread.currentThread().getName());
        // sleep的时候，烦人的InterruptedException到底是什么？
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i<= 1; i++) {
            Thread thread =
                    new Thread(new PrintStoryRunnable(TEXT, 200 * i), "我的线程-" + i);

            thread.start();
//            thread.stop();
            threads.add(thread);
        }

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println();
        System.out.println("开始interrupt线程");

        // interrupt是一个标识，需要thread里执行的代码自己去检查
        // 如果线程不是在sleep，或者执行一些确实处理这个状态的方法，那么调用interrupt没有任何作用
        threads.forEach(Thread::interrupt);
        System.out.println("interrupr线程结束，继续sleep5秒钟");
        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println("启动线程结束，名字叫做" + Thread.currentThread().getName());
    }

    static class PrintStoryRunnable implements Runnable {
        private String text;
        private long interval;

        public PrintStoryRunnable(String text, long interval) {
            this.text = text;
            this.interval = interval;
        }

        @Override
        public void run() {
            try {
                System.out.println("执行这段代码的线程名字叫做" + Thread.currentThread().getName());
                printSlowly(text, interval);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printSlowly(String text, long interval) throws InterruptedException {
        for (char ch : text.toCharArray()) {
            Thread.sleep(interval);
            System.out.print(ch);
        }
        System.out.println();
    }
}
