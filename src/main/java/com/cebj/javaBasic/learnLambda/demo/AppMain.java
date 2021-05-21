package com.cebj.javaBasic.learnLambda.demo;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        List<String> strs = addElementsToList(new ArrayList<>());
        strs.forEach(new Processer<String>());
        strs.forEach(new Processor<String>());
    }

    private static List<String> addElementsToList(List<String> list) {
        for (int i = 0; i < 5; i++) {
            list.add("str" + i);
        }
        return list;
    }
}
