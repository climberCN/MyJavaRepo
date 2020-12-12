package com.cebj.javaBasic.methods;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.methods
 * @date 2020/12/12 0012 11:14
 */
public class MerchandiesDescAppMainV2 {
    public static void main(String[] args) {
        MerchandiseV2 merchandiseV2 = new MerchandiseV2();

        merchandiseV2.name = "书桌";
        merchandiseV2.soldPrice = 999.9;
        merchandiseV2.purchasePrice = 500;
        merchandiseV2.count = 40;
        merchandiseV2.id = "DESK9527";

        merchandiseV2.describe();
    }
}
