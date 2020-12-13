package com.cebj.javaBasic.methods;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.methods
 * @date 2020/12/12 0012 11:13
 */
public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

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

    // >> TODO 在方法定义中指定方法的返回值类型
    // >> TODO Java中一个方法只能有一个返回值，该返回值类型可以是基本数据类型也可以是引用数据类型，但只能由一个，如果不需要返回值则用void表示。
    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        if (profit <= 0) {
            return 0;
        }
        return profit;
    }

    // count为double类型
    public double getCurrentCount() {
        return count;
    }

    // soldPrice为double类型
    public int getIntSoldPrice() {
        return (int)soldPrice;
    }

    public double buy(int countToBuy) {
        if (countToBuy > count) {
            System.out.println("商品库存不足");
            return -1;
        }
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount * purchasePrice / 2;
        count -= countToBuy;
        return totalCost;
    }
}
