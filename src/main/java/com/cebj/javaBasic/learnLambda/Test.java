package com.cebj.javaBasic.learnLambda;

public interface Test {
    default void test() {
        System.out.println(this);
    }
}
