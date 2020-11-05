package com.cebj.Generic;

public class Generator2 implements GenericInterface<String> {
    private String[] fruits = new String[]{"Applie", "Binana", "Pear"};

    @Override
    public String next() {
        return fruits[1];
    }
}
