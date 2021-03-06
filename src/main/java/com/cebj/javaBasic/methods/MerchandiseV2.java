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
                        + "赠品是："  + this.gift.name
        );
    }

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

    // 方法的返回值只能有一个，但是方法的参数可以有任意多个，多个参数之间使用逗号分隔
    // 参数可以有0个，有1个，有多个
    public double buyAndPrintLeft(int countToBuy, boolean printLeft) {
        if (count < countToBuy) {
            System.out.println("商品库存不够");
            if (printLeft) {
                System.out.println("商品库存为：" + count);
            }
            return -1;
        }
        int fullPriceCount = countToBuy / 2 + countToBuy % 2;
        int halfPriceCount = countToBuy - fullPriceCount;
        double totalCost = purchasePrice * fullPriceCount + halfPriceCount * purchasePrice / 2;
        count -= countToBuy;
        if (printLeft) {
            System.out.println("商品剩余数量为：" + count);
        }
        return totalCost;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型，甚至是类自己本身的对象都没有问题
    // 本函数用来比较本对象占用的资金数是否比另外一个商品占用的资金数大
    public boolean totalValueBiggerThan(MerchandiseV2 merchandiseV2) {
        return count * purchasePrice > merchandiseV2.purchasePrice * merchandiseV2.count;
    }

    // >> TODO 参数可以是任何类型，包括自定义类型
    public boolean isTheBigggestTotalValueOne(LittleSuperMarket littleSuperMarket) {
        double totalValue = count * purchasePrice;
        for (int i = 0; i < littleSuperMarket.merchandises.length; i++) {
            MerchandiseV2 m2 = littleSuperMarket.merchandises[i];
            double newTotalValue = m2.purchasePrice * m2.count;
            if (totalValue < newTotalValue) {
                // 执行到return语句的时候，方法直接结束，不管是不是在循环中，是在第几层循环
                return false;
            }
        }
        return true;
    }

    public MerchandiseV2 gift;

    public double getSoldPrice() {
        return soldPrice;
    }

    public String getName() {
        return name;
    }

    public MerchandiseV2 getGiftAndHowCanOutsideChangeIt() {
        return gift;
    }

    public void willOutsideValueChangeIfParameterValueChangeHereRef(MerchandiseV2 m2) {
        m2 = gift;
    }

    public void willOutsideValueChangeIfParameterValueChangeHerePrime(int intVal) {
        intVal = 99999999;
    }

    public void  changeToTheSameGift(MerchandiseV2 m2) {
        m2.gift = gift;
    }
}
