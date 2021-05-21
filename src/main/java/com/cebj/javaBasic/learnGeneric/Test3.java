package com.cebj.javaBasic.learnGeneric;

import com.cebj.javaBasic.learnGeneric.define.MyGenericClass;
import com.cebj.javaBasic.learnGeneric.ext.GrandParent;
import com.cebj.javaBasic.learnGeneric.ext.Parent;

public class Test3 {

    public static void main(String[] args) {
        MyGenericClass mc = new MyGenericClass("a", "b");
        MyGenericClass<GrandParent, Parent> cast = mc;
        System.out.println(cast.getFirst());

        GrandParent first = cast.getFirst();
        System.out.println(first);
    }
}
