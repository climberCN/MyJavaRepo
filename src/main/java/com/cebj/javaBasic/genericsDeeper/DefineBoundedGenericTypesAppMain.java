package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.define.MyGenericClassBounded;

import java.lang.reflect.Field;

public class DefineBoundedGenericTypesAppMain {
    public static void main(String[] args) throws NoSuchFieldException {
        // 如果在定义泛型的时候，就指定了类型，那么引用的类型
        // 就是指定的类型的最父级别的类型，在这里就是GrandParent
        Field myType = MyGenericClassBounded.class.getDeclaredField("myType");
        System.out.println(myType.getType());
    }
}
