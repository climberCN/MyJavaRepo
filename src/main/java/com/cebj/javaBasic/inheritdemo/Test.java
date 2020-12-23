package com.cebj.javaBasic.inheritdemo;

import com.cebj.javaBasic.inheritdemo.supermarket.MerchandiseV2;
import com.cebj.javaBasic.inheritdemo.supermarket.PhoneExtendsMerchandise;

public class Test {
    public static void main(String[] args) {
        MerchandiseV2 m2 = new MerchandiseV2();
        m2.describe();
        m2.inheritStaticMethod();
    }
}
