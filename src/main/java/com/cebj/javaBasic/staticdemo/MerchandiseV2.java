package com.cebj.javaBasic.staticdemo;

public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;


    public MerchandiseV2(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
    }

    public MerchandiseV2(String name, String id, int count, double soldPrice) {
        this(name, id, count, soldPrice, soldPrice * 0.8);
    }

    public MerchandiseV2() {
        this("无名", "000", 0, 1, 1.1);

    }

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + (soldPrice - purchasePrice));
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }


    public double buy() {
        return buy(1);
    }

    public double buy(int count) {
        return buy(count, false);
    }

    double discount = 0.95;

    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * discount;
        } else {
            return totalCost;
        }
    }
}
