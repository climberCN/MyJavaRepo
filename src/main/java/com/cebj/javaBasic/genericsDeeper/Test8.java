package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.GrandParent;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test8 {

    public static void main(String[] args) {
        // 除了协变，还有逆变，语法如下：
        // <? super Parent> 允许的类型为Parent或者其父类
        List<? super Parent> l1 = null;

        l1 = new ArrayList<Parent>();
        l1.add(new Parent());
//        l1.add(new GrandParent());
        l1.add(new Children());
//        l1.add(new Object());

        l1 = new ArrayList<GrandParent>();
        l1.add(new Parent());
//        l1.add(new GrandParent());
        l1.add(new Children());
//        l1.add(new Object());

//        l1 = new ArrayList<Children>();


        // >> TODO 无论是协变还是逆变，都只能用在引用上，而不能在创建对象时使用其做为泛型参数
//        List<? extends Parent> g2ListExt11 = new ArrayList<? extends Parent>();
//        List<? super Parent> g2ListSup11 = new ArrayList<? super Parent>();
    }
}
