package com.cebj.javaBasic.methods;

public class LittleSuperMarketV3 {
    public String superMarketName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    // 存放商品信息
    public MerchandiseV3[] merchandises;
    // 存放商品销售数量
    public int[] merchandiseSold;

    public MerchandiseV3 getBiggestProfitMerchandise1() {
        MerchandiseV3 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV3 m = merchandises[i];
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

    public MerchandiseV3 getBiggestProfitMerchandise() {
        MerchandiseV3 curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            MerchandiseV3 m = merchandises[i];
            // 这个逻辑有问题吗？相同的利润怎么判断？
            if (curr == null || curr.calculateProfit() < m.calculateProfit()) {
                curr = m;
            }
        }
        return curr;
    }
}
