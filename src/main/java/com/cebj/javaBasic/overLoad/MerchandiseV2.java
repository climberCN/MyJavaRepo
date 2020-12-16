package com.cebj.javaBasic.overLoad;

public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void init(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
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

    // 为了使用方便，买一个，不传参
    public double buyOne() {
        if (this.count < 1) {
            return -1;
        }
        this.count--;
        return 1 * soldPrice;
    }

    // 买好几个
    public double buyCount(int count) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        return count * soldPrice;
    }

    // VIP会员，购买95折
    public double buyAsVIP(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * 0.95;
        }else {
            return totalCost;
        }
    }
}
