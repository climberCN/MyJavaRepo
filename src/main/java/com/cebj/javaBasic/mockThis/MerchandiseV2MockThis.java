package com.cebj.javaBasic.mockThis;

public class MerchandiseV2MockThis {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void describe(MerchandiseV2MockThis This) {
        double netIncome = soldPrice - purchasePrice;
        System.out.println(
                "商品名字：" + This.name + " "
                        + "id：" + This.id + " "
                        + "商品售价：" + This.soldPrice + " "
                        + "商品进价：" + This.purchasePrice + " "
                        + "商品库存：" + This.count + " "
                        + "单品毛利润：" + (This.soldPrice - This.purchasePrice)
        );
    }

    public double calculateProfit(MerchandiseV2MockThis This) {
        double profit = This.soldPrice - This.purchasePrice;
        return profit;
    }

    public void duplicateName(int count) {

    }

    public int getCount(MerchandiseV2MockThis This) {
        return This.count;
    }

    public void addCount(MerchandiseV2MockThis This, int count) {
        This.count += count;
    }

    public boolean hasEnoughCountFor(MerchandiseV2MockThis This, int count) {
        return This.count > count;
    }

    public void makeEnoughFor(MerchandiseV2MockThis This, int count) {
        boolean hasEnough = This.hasEnoughCountFor(This, count);
        if (!hasEnough) {
            int toBeAdd = count - This.count;
            This.addCount(This, toBeAdd);
        }
    }
}
