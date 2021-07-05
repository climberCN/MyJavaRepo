package com.cebj.javaBasic.joinDemo;

import org.apache.commons.math3.fitting.leastsquares.EvaluationRmsChecker;

import java.util.ArrayList;
import java.util.List;

public class ThreadJoinAppMain {

    private static final List<String> CONTENTS = new ArrayList<>();

    private static long WORKING_DURATION = 0;

    public static void main(String[] args) throws InterruptedException {

        long mainStart = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":开始抓取网页内容");
                long start = System.currentTimeMillis();
                String content = getContentFromWeb();
                long threadWorkingDuration = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ":抓取网页内容结束");
                synchronized (CONTENTS) {
                    CONTENTS.add(content);
                    // 这里是多个线程同时操作WORKING_DURATION变量，它不是对象，但是是类变量
                    // 类变量没有在堆中，它也可以被多个线程操作吗？
                    WORKING_DURATION += threadWorkingDuration;
                }
            }, "线程-" + i);
            thread.start();
            threads.add(thread);
        }

        // sleep一下，让线程都起来
        Thread.sleep(1);

        System.out.println(" ------------ 主线程开始 join  ------------ ");
        for (Thread thread : threads) {
            String name = thread.getName();
            System.out.println(" ------------ 主线程开始join " + name + " ------------ ");
            thread.join();
            System.out.println(" ------------ 主线程join " + name + " 结束 ------------ ");
        }

        System.out.println(" ------------ 主线程join结束，获取的内容为： ------------ ");
        CONTENTS.forEach(s -> {
            System.out.print(s.length() + "：");
            System.out.println(s);
        });

        long mainWorkDuration = System.currentTimeMillis() - mainStart;

        //多线程的意义就是让工作并发地处理，使用更多的资源（CPU，磁盘，网络等），以便让工作更快完成
        System.out.println("工作线程累计工作时间：" + WORKING_DURATION);
        System.out.println("主线程工作时间：" + mainWorkDuration);
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
