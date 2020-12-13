package com.cebj.javaBasic.methods;

public class LittleSuperMarket {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    // 存放商品信息
    public MerchandiseV2[] merchandises;
    // 存放商品销售数量
    public int[] merchandiseSold;

    public MerchandiseV2 getBiggestProfitMerchandise() {
        MerchandiseV2 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV2 m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit < newProfit) {
                curr = m;
            }
        }
        return curr;
    }
}
