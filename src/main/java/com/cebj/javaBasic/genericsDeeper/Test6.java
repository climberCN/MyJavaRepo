package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.GrandParent;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        List<? extends Parent> ret = new ArrayList<Parent>();
//        ret.add(new GrandParent());
//        ret.add(new Parent());
//        ret.add(new Children());
    }
}
