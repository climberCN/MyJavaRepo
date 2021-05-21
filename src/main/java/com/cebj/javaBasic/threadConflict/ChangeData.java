package com.cebj.javaBasic.threadConflict;

import java.util.concurrent.TimeUnit;

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
            dataHolder.change(delta);
            if (delta == 2) {
                System.out.println("increase执行一次叠加");
            } else if (delta == -2) {
                System.out.println("decrease执行一次叠加");
            } else {
                System.out.println("什么都没执行");
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dataHolder.print();
    }
}
