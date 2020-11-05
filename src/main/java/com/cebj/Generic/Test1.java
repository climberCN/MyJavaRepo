package com.cebj.Generic;

/**
 * 我们知道Integer是Number的子类，之前我们也验证过numberGenericParadigm<Integer>和numberGenericParadigm<String>是同一种类型。
 * 那么问题来了，在numberGenericParadigm<Number>作为形参的方法中，能否使用numberGenericParadigm<Integer>的实例传入呢？
 * 在逻辑上类似于numberGenericParadigm<Number>和numberGenericParadigm<Integer>是否可以看成是具有父子关系的泛型类型呢？
 */
public class Test1 {
    public static void main(String[] args) {
        GenericParadigm<Number> numberGenericParadigm = new GenericParadigm<Number>(100);
        GenericParadigm<Integer> integerGenericParadigm = new GenericParadigm<Integer>(10);
        showKeyValue(numberGenericParadigm);
        showKeyValue(integerGenericParadigm);
    }

    public static void showKeyValue(GenericParadigm<?> obj) {
        System.out.println("key value is = " + obj.getKey());
    }
}
