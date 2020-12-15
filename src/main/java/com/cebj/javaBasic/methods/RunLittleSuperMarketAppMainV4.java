package com.cebj.javaBasic.methods;

public class RunLittleSuperMarketAppMainV4 {
    public static void main(String[] args) {
        LittleSuperMarketV3 littleSuperMarket = new LittleSuperMarketV3();
        littleSuperMarket.superMarketName = "有家小超市";
        littleSuperMarket.address = "浦东新区世纪大道666号";
        littleSuperMarket.parkingCount = 100;
        littleSuperMarket.merchandises = new MerchandiseV3[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];
        MerchandiseV3[] all = littleSuperMarket.merchandises;

        // 遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            // 创建并给商品的属性赋值
            MerchandiseV3 m = new MerchandiseV3();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = (i + 1) * 100;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            all[i] = m;
            m.describe();
        }
        System.out.println("LittleSuperMarket的对象是：" + littleSuperMarket);
        System.out.println("下面请利润最高的商品自我介绍");
        MerchandiseV3 m = littleSuperMarket.getBiggestProfitMerchandise();
        m.describe();
        System.out.println("利润最高的MerchandiseV3对象是：" + m);
        if (!m.hasEnoughCountFor(500)) {
            System.out.println("补充库存");
            int toBeAdded = 500;
            littleSuperMarket.incomingSum -= toBeAdded * m.purchasePrice;
            m.addCount(toBeAdded);
        }
    }
}
