package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class MoreGenericsAppMain {
    public static void main(String[] args) {
        ArrayList<Children> g3List = new ArrayList<>();
        // 这么传参数不行，泛型类型不管继承关系，只管严格的匹配
        // 换句话说，Children是Parent的子类，但是List<children>不是List<Parent>的子类
//        justG2Method(g3List);
        extMethod(g3List);

        // 同样的道理，我们也可以创建协变的引用
        // 让它可以接受的List引用的泛型类型为Parent或者其子类
        List<? extends Parent> g2ListExt = null;
        g2ListExt = new ArrayList<Children>();
        g2ListExt = new ArrayList<Parent>();
    }

    // 协变语法如下，意思就是这个参数可以接受的List引用的泛型类型为Parent或其子类
    public static void extMethod(List<? extends Parent> extParam) {
    }

    public static void justG2Method(List<Parent> extParam) {}

    public static void supMethod(List<? super Parent> extParam) {}
}
