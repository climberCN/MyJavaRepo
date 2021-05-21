package com.cebj.javaBasic.learnLambda.demo;

import java.util.function.Consumer;

public class Processer<T> implements Consumer<T> {
    @Override
    public void accept(T t) {
        System.out.println(t + "_zjh");
    }
}
