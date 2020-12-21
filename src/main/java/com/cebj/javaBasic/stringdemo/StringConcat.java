package com.cebj.javaBasic.stringdemo;

import com.cebj.javaBasic.staticdemo.MerchandiseV2WithStaticVariable;

public class StringConcat {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = a + b;

        System.out.println("a + b = " + c);

        boolean aBiggerThanB = a > b;
        System.out.println("a > b 是" + aBiggerThanB + "的");
        System.out.println("a + b = " + a + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a * b = " + a * b);
        System.out.println("a + v = " + new MerchandiseV2WithStaticVariable());
    }
}
