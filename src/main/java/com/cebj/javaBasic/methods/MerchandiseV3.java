package com.cebj.javaBasic.methods;

public class MerchandiseV3 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public void dupicateName(int count) {
        this.describe();
    }

    // 方法的定义：
    // 访问修饰符 返回类型 方法名(参数列表) {方法体}
    // 返回类型：无需返回值则用void表示，void是Java中的关键字
    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println(
                "商品名字：" + this.name + " "
                        + "id：" + this.id + " "
                        + "商品售价：" + this.soldPrice + " "
                        + "商品进价：" + this.purchasePrice + " "
                        + "商品库存：" + this.count + " "
                        + "单品毛利润：" + (this.soldPrice - this.purchasePrice)
        );
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    public void addCount(int count) {
        // >> TODO 方法里隐藏着一个this自引用，指向调用这个方法的对象。
        // >> TODO 使用一个对象调用方法，也叫做在这个对象上调用方法。因为方法可以访问这个对象的值。
        // >> TODO 使用一个成员变量的完整形态，是“this.成员变量的名字”
        this.count += count;
        System.out.println("MerchandiseV2的addCount方法使用的对象是：" + this);
    }

    public boolean hasEnoughCountFor(int count) {
        System.out.println("MerchandiseV2的hasEnoughCountFor方法使用的对象是：" + this);
        return this.count > count;
    }
}
