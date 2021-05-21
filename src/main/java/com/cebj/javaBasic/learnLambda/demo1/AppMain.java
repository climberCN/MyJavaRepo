package com.cebj.javaBasic.learnLambda.demo1;

public class AppMain {
    public static void main(String[] args) {
        MyArrayList strs = new MyArrayList();

        System.out.println("---------------最原始的for循环---------------");
        for (int i = 0; i < MyArrayList.LENGTH; i++) {
            System.out.println(strs.get(i) + "_test");
        }


        System.out.println("---------------匿名内部类实现---------------");
        strs.forEach(
                new Consumer() {
                    @Override
                    public void acceptStr(String s) {
                        System.out.println(s + "_test");
                    }
                });

        System.out.println("---------------lambda实现---------------");
        strs.forEach(s -> System.out.println(s + "_test"));
    }
}
