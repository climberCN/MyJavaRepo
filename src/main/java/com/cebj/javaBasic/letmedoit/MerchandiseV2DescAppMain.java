package com.cebj.javaBasic.letmedoit;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 m2 = new MerchandiseV2();
        m2.init("书桌","DESK9527", 40, 999.9, 500);
        m2.describe();
    }
}
