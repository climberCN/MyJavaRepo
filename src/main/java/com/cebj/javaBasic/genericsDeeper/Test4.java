package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        extMethod(new ArrayList<Children>());
        extMethod(new ArrayList<Parent>());
    }

    public static void extMethod(List<? extends Parent> extParam) {}
}
