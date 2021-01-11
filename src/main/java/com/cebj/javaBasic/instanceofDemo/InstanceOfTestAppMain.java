package com.cebj.javaBasic.instanceofDemo;

import com.cebj.javaBasic.instanceofDemo.supermarket.LittleSuperMarket;
import com.cebj.javaBasic.instanceofDemo.supermarket.MerchandiseV2;
import com.cebj.javaBasic.instanceofDemo.supermarket.Phone;
import com.cebj.javaBasic.instanceofDemo.supermarket.ShellColorChangePhone;

public class InstanceOfTestAppMain {
    public static void main(String[] args) {
        int merchandiseCount = 600;
        LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
                "世纪大道1号", 500, merchandiseCount, 100);

        // >> TODO instanceof操作符，可以判断一个引用指向的对象是否是某一个类型或者其子类
        // TODO 是则返回true，否则返回false
        for (int i = 0; i < merchandiseCount; i++) {
            MerchandiseV2 m = superMarket.getMerchandiseOf(i);
            if (null instanceof ShellColorChangePhone) {
                // TODO 先判断，再强制类型转换，比较安全
                ShellColorChangePhone ph = (ShellColorChangePhone) m;
                System.out.println(ph.getBrand());
            }else {
                System.out.println("null");
            }
        }
    }
}
