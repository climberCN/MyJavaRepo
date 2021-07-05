package com.cebj.javaBasic.waitnotify;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final int SLEEP_SEC = 2;
    private static final int THREAD_COUNT = 5;
    private static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    synchronized (locker) {
                        System.out.println(getThreadName() + "抢到锁");
                        System.out.println(getThreadName() + "开始工作两秒");
                        Thread.sleep(TimeUnit.SECONDS.toMillis(SLEEP_SEC));
                        System.out.println(getThreadName() + "进入WAITING状态");
                        locker.wait();
                        System.out.println(getThreadName() + "线程被唤醒，开始继续执行");
                        System.out.println(getThreadName() + "开始工作两秒");
                        Thread.sleep(TimeUnit.SECONDS.toMillis(SLEEP_SEC));
                        System.out.println(getThreadName() + "线程执行结束");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "我的线程" + i).start();
        }
        Thread.sleep(2000);
//        Thread.sleep(TimeUnit.SECONDS.toMillis(20));
        System.out.println("****************************************");
        System.out.println(getThreadName() + "开始唤醒所有线程...");
//        synchronized (lockerObj) {
//            for (int i = 0; i < THREAD_COUNT; i++) {
//                lockerObj.notify();
//            }
//        }
        synchronized (locker) {
            locker.notifyAll();
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }
}
