package com.cebj.javaBasic.waitnotify;


import java.util.concurrent.TimeUnit;

public class ThreadWaitNotify {

    public static void main(String[] args) {

        Object locker = new Object();

        int workingSec = 2;
        int threadCount = 5;
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(getName() + ": 线程开始工作......");
                try {
                    synchronized (locker) {
                        sleepSec(workingSec);
                        System.out.println(getName() + "进入等待");
                        // wait方法必须在进入相应对象的synchronized块中才能调用
                        // 执行wait方法之后，自动失去对象的monitor，也就是说别的线程可以进入这个对象
                        // 的synchronized代码块了
                        locker.wait();
                        // 被唤醒的线程，就相当于执行过了wait方法，开始向下执行
                        // 如果wait不是synchronized块中的最后一行，那么第一件事情就是“排队”获取之前失去
                        // 的monitor
                        // 排队加引号是因为synchronized是非公平的，也就是说，不是谁先等待就能先获得
                        System.out.println(getName() + ": 线程继续......");
                        sleepSec(2);
                        System.out.println(getName() + ": 结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "工作线程" + i).start();
        }
        // 如果notify/notifyAll在wait之前，会怎么样？
        System.out.println("------------- 唤醒线程开始sleep -------------");
        // 人工划重点：如果执行notify的时候，线程还没有进入wait状态，那么notify是没有效果的
        // 人工划重点：先notify，后进入wait，就是所谓的lost notification问题，可能造成线程无法运行
        // 人工划重点：如果让唤醒的线程sleep的比woker短（sleep时间+1变-1，或者干脆不sleep），
        // 也就是先进行了notify，那么就可能会造成这个问题
        // 人工划重点：为什么说是可能呢？因为synchronized还是阻碍了notify的执行，但是notify有机会在wait前执行了
        sleepSec(workingSec - 1);
        System.out.println("------------- 唤醒线程sleep结束 -------------");
        synchronized (locker) {
            // notify/notifyALl方法必须在进入相应对象的synchronized块中才能调用
//            System.out.println("------------- 开始唤醒所有 -------------");
//            locker.notifyAll();

            for (int i = 0; i < threadCount; i++) {
                System.out.println("------------- 开始逐个唤醒 -------------");
                locker.notify();
            }
        }
    }



    private static void sleepSec(int sec) {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(sec));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }

}
