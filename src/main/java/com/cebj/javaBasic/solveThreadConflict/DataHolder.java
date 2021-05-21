package com.cebj.javaBasic.solveThreadConflict;

public class DataHolder {

    private Object lockObj = new Object();
    private long number = 0;
    private static long numberStatic = 0;

    // 一个synchronized解决问题
    public synchronized void change(long delta) {
        System.out.println(Thread.currentThread().getName() + "进入changeStatic方法");
        System.out.println(Thread.currentThread().getName() + "开始操作dataHolder的numberStatic数据");
        number += delta;
        System.out.println(Thread.currentThread().getName() + "完成对dataHolder的numberStatic属性的操作");
        System.out.println(Thread.currentThread().getName() + "离开changeStatic方法");
        System.out.println("*********************************************************");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeSyncBlock(long delta) {
        int abc = 99;
        synchronized (lockObj) {
            System.out.println(Thread.currentThread().getName() + "进入同步代码块");
            System.out.println(Thread.currentThread().getName() + "开始操作dataHolder的数据");
            number += delta;
            System.out.println(Thread.currentThread().getName() + "完成对dataHolder的属性的操作");
            System.out.println(Thread.currentThread().getName() + "离开同步代码块");
            System.out.println("*********************************************************");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int cde = 987;
    }

    // 一个synchronized解决问题
    public synchronized static void changeStatic(long delta) {
        System.out.println(Thread.currentThread().getName() + "进入changeStatic方法");
        System.out.println(Thread.currentThread().getName() + "开始操作dataHolder的numberStatic数据");
        numberStatic += delta;
        System.out.println(Thread.currentThread().getName() + "完成对dataHolder的numberStatic属性的操作");
        System.out.println(Thread.currentThread().getName() + "离开changeStatic方法");
        System.out.println("*********************************************************");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void print() {
        System.out.println("Number=" + number);
    }

    public static void printStatic() {
        System.out.println("static Number=" + numberStatic);
    }

}
