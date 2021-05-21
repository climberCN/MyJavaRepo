package com.cebj.javaBasic.solveThreadConflict;

public class MultiThreadChaos {
    public static void main(String[] args) {
        // TODO 同样的运算，安排在两个线程里做，结果就不一样了
        DataHolder dataHolder = new DataHolder();
//        DataHolder dataHolder2 = new DataHolder();
        Thread increaseThread =
                new Thread(new ChangeData(2, Integer.MAX_VALUE, dataHolder),"increase线程");
        Thread decreaseThread =
                new Thread(new ChangeData(-2, Integer.MAX_VALUE, dataHolder), "decrease线程");
        System.out.println("执行开始");
        increaseThread.start();
        decreaseThread.start();
    }
}
