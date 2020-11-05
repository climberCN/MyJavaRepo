package com.cebj.Generic;

public class MethodGenericUpbond {
    public static <T extends Number> T getKeyValue(GenericParadigm<T> container) {
        return container.getKey();
    }

    public static void main(String[] args) {
        GenericParadigm<String> stringGenericParadigm = new GenericParadigm<String>("hahahaha");
        GenericParadigm<Integer> integerGenericParadigm = new GenericParadigm<Integer>(100);
        GenericParadigm<Float> floatGenericParadigm = new GenericParadigm<Float>(100.1f);
        GenericParadigm<Double> doubleGenericParadigm = new GenericParadigm<Double>(100.2);

//        getKeyValue(stringGenericParadigm);
        getKeyValue(integerGenericParadigm);
        getKeyValue(floatGenericParadigm);
        getKeyValue(doubleGenericParadigm);
    }
}
