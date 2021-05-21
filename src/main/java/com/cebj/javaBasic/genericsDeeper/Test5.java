package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        // 同样的道理，我们也可以声明一个协变的引用：
        // 让它可以的List引用的泛型类型为Parent或者其子类
        List<? extends Parent> ret1 = null;
        ret1 = new ArrayList<Children>();
        ret1 = new ArrayList<Parent>();
    }
}
