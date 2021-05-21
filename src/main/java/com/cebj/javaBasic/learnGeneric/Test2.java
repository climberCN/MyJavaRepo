package com.cebj.javaBasic.learnGeneric;

import com.cebj.javaBasic.learnGeneric.define.MyGenericClass;

import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) throws NoSuchFieldException {
        MyGenericClass<String, Object> inst1 = new MyGenericClass<>("inst1", new Object());
        String first = inst1.getFirst();
        System.out.println(first);

        Object a = "ghpost";
        String another1 = inst1.getAnother(a);
        Object another2 = inst1.getAnother(a);

        // 错误的使用例子
        String another3 = inst1.getAnother(new Object());
    }
}
