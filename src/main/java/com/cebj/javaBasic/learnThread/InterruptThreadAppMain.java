package com.cebj.javaBasic.learnThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterruptThreadAppMain {

    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序开始，执行的线程名字叫做" + Thread.currentThread().getName());
        // sleep的时候，烦人的InterruptedException到底是什么？
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i<= 1; i++) {
            Thread thread =
                    new Thread(new NotHandleInterrupt(TimeUnit.SECONDS.toMillis(8)), "我的线程-" + i);

            thread.start();
//            thread.stop();
            threads.add(thread);
        }

        // 主线程休眠5秒，对新建线程没有任何影响
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

    static class NotHandleInterrupt implements Runnable {

        private long duration;

        public NotHandleInterrupt(long duration) {
            this.duration = duration;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行开始");

            long start = System.currentTimeMillis();
            long counter = 0;
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            System.out.println(Thread.currentThread().getName() + "的isInterrupted=" + isInterrupted);
            while (true) {
                counter++;
                if (isInterrupted != Thread.currentThread().isInterrupted()) {
                    isInterrupted = Thread.currentThread().isInterrupted();
                    System.out.println("发现线程" +
                            Thread.currentThread().getName() +
                            "的isInterrupted变化为：" + isInterrupted);
                    System.out.println("但是线程决定什么都不做");
                    System.out.println("到目前为止，" +
                            Thread.currentThread().getName() +
                            " 运行了" +
                            TimeUnit.MILLISECONDS.toSeconds((long)System.currentTimeMillis() - start) + "秒");
                }
                if (System.currentTimeMillis() - start > duration) {
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName() + "执行结束");
        }
    }
}
