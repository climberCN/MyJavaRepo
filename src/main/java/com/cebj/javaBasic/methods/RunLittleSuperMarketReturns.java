package com.cebj.javaBasic.methods;

public class RunLittleSuperMarketReturns {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();

        littleSuperMarket.superMarketName = "有家小超市";
        littleSuperMarket.address = "浦东新区大道666号";
        littleSuperMarket.parkingCount = 100;
        littleSuperMarket.merchandises = new MerchandiseV2[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];

        MerchandiseV2[] all = littleSuperMarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            all[i] = m;
        }
        System.out.println("下面请利润最高的商品自我介绍：");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
    }
}
