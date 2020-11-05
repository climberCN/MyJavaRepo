package com.cebj.Generic;

public class GenericUpbound {
    public static void showKeyValue(GenericParadigm<? extends Number> obj) {
        System.out.println("key value is = " + obj.getKey());
    }

    public static void main(String[] args) {
        GenericParadigm<String> stringGenericParadigm = new GenericParadigm<String>("hahahaha");
        GenericParadigm<Integer> integerGenericParadigm = new GenericParadigm<Integer>(100);
        GenericParadigm<Float> floatGenericParadigm = new GenericParadigm<Float>(100.1f);
        GenericParadigm<Double> doubleGenericParadigm = new GenericParadigm<Double>(100.2);

//        showKeyValue(stringGenericParadigm);
        showKeyValue(integerGenericParadigm);
        showKeyValue(floatGenericParadigm);
        showKeyValue(doubleGenericParadigm);
    }
}
