package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.GrandParent;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
//        List<Parent> a1 = new ArrayList<Children>();
        List<Parent> a2 = new ArrayList<Parent>();
//        List<Parent> a3 = new ArrayList<GrandParent>();
    }
}
