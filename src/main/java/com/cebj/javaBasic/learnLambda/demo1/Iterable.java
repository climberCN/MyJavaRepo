package com.cebj.javaBasic.learnLambda.demo1;

public interface Iterable {
    default void forEach(Consumer action) {
        for (int i = 0; i < MyArrayList.LENGTH; i++) {
            action.acceptStr(get(i));
        }
    }

    String get(int index);
}
