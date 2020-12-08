package com.cebj.javaBasic;

public class NullExceptionDemo {
    private static Merchandise m1;

    public static void main(String[] args) {
        System.out.println(m1);
        System.out.println(m1.name);
        m1.sayHi();
    }
}