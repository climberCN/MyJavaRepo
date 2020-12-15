package com.cebj.javaBasic.mockThis;

public class LittleSuperMarketWithMerchandiseMock {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public MerchandiseV2MockThis[] merchandises;
    public int[] merchandiseSold;

    public MerchandiseV2MockThis getBiggestProfitMerchandise(LittleSuperMarketWithMerchandiseMock This) {
        System.out.println("LittleSuperMarket的getBiggestProfitMerchandise方法使用的对象是：" + This);
        MerchandiseV2MockThis m = null;
        for (int i = 0; i < This.merchandises.length; i++) {
            if (m == null || m.calculateProfit(m) < This.merchandises[i].calculateProfit(This.merchandises[i])) {
                m = This.merchandises[i];
            }
        }
        return m;
    }
}
