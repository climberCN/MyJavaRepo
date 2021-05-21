package com.cebj.javaBasic.learnLambda.demo1;

public class MyArrayList implements Iterable {
    public static final int LENGTH = 10;
    private String[] elements = new String[LENGTH];

    public MyArrayList() {
        for (int i = 0; i < LENGTH; i++) {
            elements[i] = "str" + i;
        }
    }

    @Override
    public String get(int index) {
        return elements[index];
    }
}
