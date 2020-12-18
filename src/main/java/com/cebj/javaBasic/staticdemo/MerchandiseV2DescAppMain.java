package com.cebj.javaBasic.staticdemo;

import static com.cebj.javaBasic.staticdemo.MerchandiseV2WithStaticVariable.DISCOUNT_FOR_VIP;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2WithStaticVariable m = new MerchandiseV2WithStaticVariable("书桌", "DESK9527", 40, 999.9, 500);
        m.describe();
        System.out.println(MerchandiseV2WithStaticVariable.DISCOUNT_FOR_VIP);
        System.out.println(DISCOUNT_FOR_VIP);
    }
}
