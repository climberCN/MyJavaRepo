package com.cebj.javaBasic.whatisthread;

import java.util.concurrent.TimeUnit;

public class CreateThreadAppMain {

    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) throws InterruptedException {
        // 代码是被线程执行的，任何代码都可以通过Thread.currentThread()获取执行当前代码的线程
        System.out.println("程序开始，执行的线程名字叫做" + Thread.currentThread().getName());

        // 改成2试试看
        for (int i = 1; i <= 2; i++) {
            // 创建线程的方法
            // Runnable接口里的run是线程执行的方法，执行完毕，线程就结束了。
            // 理解代码是在线程里被执行的，同样的代码可以被多个线程执行。
            // 暂停一下Java，看看有多少线程，每个线程的名字等信息。

            Thread thread = new Thread(new MyPrintSlowly(), "我的线程-" + i);
            thread.start();
        }
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println();
    }

    private static class MyPrintSlowly implements Runnable {

        @Override
        public void run() {
            try {
                double num = Math.random();
                System.out.println("执行这段代码的线程名字叫做" + Thread.currentThread().getName());
                printSlowly(TEXT, 300);
                System.out.println(Thread.currentThread().getName() + "执行结束");
            } catch (InterruptedException e) {
                throw new RuntimeException("", e);
            }
        }

        public void printSlowly(String text, long interval) throws InterruptedException {
            for (char ch : text.toCharArray()) {
                System.out.print(ch);
                Thread.sleep(interval);
            }
            System.out.println();
        }
    }
}
