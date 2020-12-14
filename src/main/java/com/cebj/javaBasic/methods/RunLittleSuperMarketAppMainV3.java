package com.cebj.javaBasic.methods;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.methods
 * @date 2020/12/14 0014 23:21
 */
public class RunLittleSuperMarketAppMainV3 {
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
        // >> TODO 方法的代码可以影响方法之外的数据。我们可以通过指向同一个对象的引用，操作这个对象里的属性
        MerchandiseV2 paramRef = littleSuperMarket.merchandises[2];

        m.gift = giftBowl;
        System.out.println("gift变化大法执行前");
        m.describe();
        paramRef.describe();
        m.changeToTheSameGift(paramRef);
        System.out.println("gift变化大法执行后");
        paramRef.describe();

        //-------------返回值---------------
        // >> TODO 给返回值赋值，并不会影响用来充当返回值的变量
        MerchandiseV2 giftOfM;
        // >> TODO 可以通过返回值，操作同一个对象
        System.out.println("获取m的赠品，并修改这个赠品对象的采购价格");
        System.out.println("修改前");
        m.describe();
        giftOfM = m.getGiftAndHowCanOutsideChangeIt();
        giftOfM.purchasePrice = giftOfM.purchasePrice * 10;
        System.out.println("修改后");
        m.describe();
    }
}
