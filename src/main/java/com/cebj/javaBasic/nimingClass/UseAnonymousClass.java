package com.cebj.javaBasic.nimingClass;

import com.cebj.javaBasic.nimingClass.superclass.Phone;
import com.cebj.javaBasic.nimingClass.superclass.UnitSpec;

public class UseAnonymousClass {
    public static void main(String[] args) {
        Phone phone = new Phone(
                "手机001", "Phone001", 100, 1999, 999,
                4.5, 3.5, 4, 128, "索尼", "安卓"
        );

        printSpec(phone.getCpu());

        // 这里我们把匿名类作为一个参数传入了函数printSpec，其在main函数中定义
        // 本身还是局部内部类。
        printSpec(new UnitSpec() {
            @Override
            public double getNumSpec() {
                return 123;
            }

            @Override
            public String getProducer() {
                return "new as an argument";
            }
        });
    }

    private static void printSpec(UnitSpec spec) {
        System.out.println("Spec producer=" + spec.getProducer() + ". Num=" + spec.getNumSpec());
    }
}
