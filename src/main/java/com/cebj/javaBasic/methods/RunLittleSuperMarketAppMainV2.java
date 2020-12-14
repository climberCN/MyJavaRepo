package com.cebj.javaBasic.methods;

public class RunLittleSuperMarketAppMainV2 {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket();
        littleSuperMarket.superMarketName = "有家小超市";
        littleSuperMarket.address = "浦东新区世纪大道666号";
        littleSuperMarket.parkingCount = 100;
        littleSuperMarket.merchandises = new MerchandiseV2[200];
        littleSuperMarket.merchandiseSold = new int[littleSuperMarket.merchandises.length];
        MerchandiseV2[] all = littleSuperMarket.merchandises;

        MerchandiseV2 giftNoodle = new MerchandiseV2();
        giftNoodle.name = "赠品-面条";
        giftNoodle.count = 20000;
        giftNoodle.purchasePrice = 5;
        giftNoodle.soldPrice = 0.05;
        giftNoodle.id = "GIFT001";

        MerchandiseV2 giftBowl = new MerchandiseV2();
        giftBowl.name = "赠品-碗";
        giftBowl.count = 20000;
        giftBowl.purchasePrice = 8;
        giftBowl.soldPrice = 0.08;
        giftBowl.id = "GIFT002";

        // 遍历并给200种商品赋值
        for (int i = 0; i < all.length; i++) {
            // 创建并给商品的属性赋值
            MerchandiseV2 m = new MerchandiseV2();
            m.name = "商品" + i;
            m.count = 200;
            m.purchasePrice = (i + 1) * 100;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            m.gift = giftNoodle;
            all[i] = m;
            m.describe();
        }

        int index = 0;

        MerchandiseV2 m = littleSuperMarket.merchandises[index];

        int c = 7;


        // ----------参数------------

        // >> TODO 参数的传递，其实就是赋值。左边是形参，右边是括号里的实参
        // TODO 类似于buy(int countToBuy = (c + 2) * 5)
        // >> TODO 参数本身可以是一个表达式，只要表达式的值类型可以和参数类型匹配就可以
        double totalCost = m.buy((c + 2) * 5);
        System.out.println("商品总价为：" + totalCost);

        // >> TODO 对于引用类型，参数同样可以是一个表达式
        // TODO 类似于totalValueBiggerThan(MerchandiseV2 merchandiseV2 = littleSuperMarket.merchandise[index + 1])
        boolean biggerThan = m.totalValueBiggerThan(littleSuperMarket.merchandises[index + 1]);
        System.out.println(biggerThan);

        // >> TODO 方法里的代码并不能改变实参里的值,对于基本数据类型，我们不能改值，对于引用数据类型，不能改指针
        // TODO 方法里使用的参数相当于一个局部变量。使用方法前，会用实参给局部变量赋值。
        MerchandiseV2 paramRef = littleSuperMarket.merchandises[2];
        int paramPrime = 7;

        System.out.println("调用前");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        m.willOutsideValueChangeIfParameterValueChangeHerePrime(paramPrime);
        // 效果类似如下代码
        // 形参实参赋值： int intVal = paramPrime;
        // 方法里执行：intVal = 99999999;
        m.willOutsideValueChangeIfParameterValueChangeHereRef(paramRef);
        // 效果类似如下代码
        // 形参实参赋值： MerchandiseV2 m2 = paramRef
        // 方法里执行： m2 = gift;

        System.out.println("调用后");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        //-------------返回值---------------

        // >> TODO 可以把有返回值的方法，当成一个成员变量，当成一个类型为返回值类型的成员变量
        // TODO 关注于返回值并忽略方法执行的部分，使用返回值，就好像在使用一个成员变量
        double soldPrice = m.getSoldPrice();

        System.out.println(soldPrice);
        m.describe();

        // >> TODO 给返回值赋值，并不会影响用来充当返回值的变量
        System.out.println("调用getGiftAndHowCanOutsideChangeIt和getSoldPrice之前");

        m.describe();
        MerchandiseV2 giftOfM = m.getGiftAndHowCanOutsideChangeIt();
        giftOfM = giftBowl;
        double mSoldPrice = m.getSoldPrice();
        mSoldPrice = 99999999;
        System.out.println("能改变m本身的gift吗？能改变m的soldPrice吗？");
        m.describe();
    }
}
