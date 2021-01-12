package com.cebj.javaBasic.finalDemo;

import com.cebj.javaBasic.finalDemo.supermarket.LittleSuperMarket;
import com.cebj.javaBasic.finalDemo.supermarket.MerchandiseV2;
import com.cebj.javaBasic.finalDemo.supermarket.Phone;

public class TestFinalRefAppMain {
    public static void main(String[] args) {
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, 600, 100);
        Phone ph = (Phone) superMarket.getMerchandiseOf(10);
        MerchandiseV2 gift = ph.getGift();

        gift.describe();
        gift.setName("变化一下商品的名字？");
        gift.setSoldPrice(9898989);
        gift.describe();
        MerchandiseV2 m0 = superMarket.getMerchandises()[0];
        superMarket.getMerchandises()[0] = gift;
        MerchandiseV2 m0Change = superMarket.getMerchandises()[0];

        m0.describe();
        m0Change.describe();
    }
}
