package com.cebj.javaBasic.genericsDeeper;

import com.cebj.javaBasic.genericsDeeper.ext.Children;
import com.cebj.javaBasic.genericsDeeper.ext.Parent;

import java.util.ArrayList;
import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<Children> l1 = new ArrayList<>();
        List<? extends Parent> l2 = l1;
        // 如果Java允许通过l2往l1里存放Parent对象，代表什么呢？
        // Java的泛型是类型擦除的，它的对象本身ArrayList()是不知道里面存的是哪种类型的
        // 而这部分信息是存放在引用中的。这个实例是不知道我们用什么样的引用指向他的。
        // 而l2说里面存的是Parent或子类，而l1则说里面存的是Children
        // 那如果我们允许l2.add(new Parent())。那l1表示里面存的是Children，而现在里面
        // 存储进了Parent。而Children的引用是不能指向Parent的。就是因为这样的问题
        // 那么我们在用l1去遍历这个list就会有问题。
        // Java为了避免这种问题，因此不允许我们通过这种方式往里面添加元素。
//        l2.add(new Parent());
    }
}
