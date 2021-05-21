package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.GrandParent;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        List<GrandParent> ret =  new ArrayList<>();
//        ret.add(new Children(3));
//        ret.add(new Parent(2));
        ret.add(new GrandParent(1));
        for (GrandParent gp : ret) {
            System.out.println(gp.getNum());
        }
    }
}
