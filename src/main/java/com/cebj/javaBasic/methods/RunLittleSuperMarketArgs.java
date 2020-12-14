package com.cebj.javaBasic.methods;

import java.util.Scanner;

public class RunLittleSuperMarketArgs {
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

        Scanner scanner = new Scanner(System.in);
        MerchandiseV2 m0 = all[0];
        while (true) {
            System.out.println("今日超市大优惠，所有商品第二件半价，选择要购买的商品索引：");
            int index = scanner.nextInt();
            if (index < 0 || index >= littleSuperMarket.merchandises.length) {
                System.out.println("欢迎再次光临");
                break;
            }
            double price = littleSuperMarket.merchandises[index].purchasePrice;
            System.out.println("商品单价为：" + price);
            System.out.println("请输入要购买的数量：");
            int count = scanner.nextInt();
//            double totalCost = littleSuperMarket.merchandises[index].buy(count);
            double totalCost = littleSuperMarket.merchandises[index].buyAndPrintLeft(count, true);
            boolean isBigger = littleSuperMarket.merchandises[index].totalValueBiggerThan(m0);
            System.out.println("所选商品是否比第一个商品占用资金额大？" + isBigger);
            System.out.println("商品总价为：" + totalCost);
        }
    }
}
