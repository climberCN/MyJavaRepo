package com.cebj.javaBasic.letmedoit;

public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.init("有家小超市", "浦东新区东大街888号", 100, 200, 200);
        System.out.println("下面请利润最高的商品自我介绍");
        littleSuperMarket.getBiggestProfitMerchandise().describe();
    }
}
