package com.cebj.javaBasic.overLoad;

public class MerchandiseV2OverrideBuyAppMain {
    public static void main(String[] args) {
        MerchandiseV2Overload m2 = new MerchandiseV2Overload();
        m2.init("书桌", "DESK9527", 40, 999.9, 500);
        // >> TODO 理解为什么返回值不是方法签名的一部分：因为不能帮我们确定调用哪个方法
        m2.buy();
        m2.describe();

        double cost = m2.buy(10);
        System.out.println(cost);
        m2.describe();

        double costVIP = m2.buy(10, true);
        System.out.println(costVIP);
        m2.describe();
    }
}
