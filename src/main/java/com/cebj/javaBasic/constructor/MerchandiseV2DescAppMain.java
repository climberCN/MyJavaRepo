package com.cebj.javaBasic.constructor;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 m = new MerchandiseV2();
        m.init("书桌", "DESK9527", 40, 999.9, 500);
        m.describe();

        MerchandiseV2WithConstructor m2 = new MerchandiseV2WithConstructor(
                "书桌",
                "DESK9527",
                40,
                999.9,
                500);
        m2.describe();
    }
}
