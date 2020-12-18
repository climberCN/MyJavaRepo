package com.cebj.javaBasic.staticmethod;

import static com.cebj.javaBasic.staticmethod.MerchandiseV2.getVIPDiscount;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.staticmethod
 * @date 2020/12/18 0018 22:48
 */
public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        MerchandiseV2 merchandise = new MerchandiseV2
                ("书桌", "DESK9527", 40, 999.9, 500);

        merchandise.describe();
        // >> TODO 使用import static来引入一个静态方法，就可以直接用静态变量名访问了
        // TODO import static 也可以使用通配符* 来引入一个类里的所有静态变量
        System.out.println(MerchandiseV2.getVIPDiscount());
        System.out.println(getVIPDiscount());
    }
}
