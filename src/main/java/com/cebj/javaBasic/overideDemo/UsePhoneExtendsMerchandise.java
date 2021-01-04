package com.cebj.javaBasic.overideDemo;

import com.cebj.javaBasic.overideDemo.supermarket.Phone;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.overideDemo
 * @date 2020/12/25 0025 15:48
 */
public class UsePhoneExtendsMerchandise {
    public static void main(String[] args) {
        Phone phone = new Phone(
                "手机001", "Phone001", 100, 1999, 999,
                4.5, 3.5, 4, 128, "索尼", "安卓"
        );
        phone.describePhone();
        System.out.println();

        System.out.println(phone.getName());
        System.out.println();

        phone.buy(100);
        phone.buy(3);

        System.out.println(phone.calculateProfit());
    }
}
