package com.cebj.javaBasic.visiable;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.visiable
 * @date 2020/12/19 0019 17:55
 */
public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        // >> TODO 非公有的类，不能在包外被调用
//        NonPublicClassCanUseAnyName name;
        MerchandiseV2 merchandise = new MerchandiseV2
                ("书桌", "DESK9527", 40, 999.9, 500);

        merchandise.describe();
    }
}
