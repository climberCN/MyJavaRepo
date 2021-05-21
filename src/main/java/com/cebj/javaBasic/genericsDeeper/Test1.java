package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.GrandParent;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
//        justG2Method(new ArrayList<Children>());
        justG2Method(new ArrayList<Parent>());
//        justG2Method(new ArrayList<GrandParent>());
    }

    public static void justG2Method(List<Parent> extParam) {
    }
}
