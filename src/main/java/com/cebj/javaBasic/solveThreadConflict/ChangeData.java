package com.cebj.javaBasic.solveThreadConflict;

public class ChangeData implements Runnable {

    private long delta;
    private long loopCount;
    private DataHolder dataHolder;

    public ChangeData(long delta, long loopCount, DataHolder dataHolder) {
        this.delta = delta;
        this.loopCount = loopCount;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run() {
        for (int i = 0; i < loopCount; i++) {
//            System.out.println(Thread.currentThread().getName() + "尝试访问changeStatic方法");
//            System.out.println("*************************************************");
//            dataHolder.changeSyncBlock(delta);
            dataHolder.change(delta);
//            DataHolder.changeStatic(delta);
        }
        dataHolder.print();
//        DataHolder.printStatic();
    }

}
