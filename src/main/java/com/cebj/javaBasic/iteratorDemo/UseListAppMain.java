package com.cebj.javaBasic.iteratorDemo;

import com.cebj.javaBasic.iteratorDemo.mylist.MyArrayList;

import java.util.Collection;

public class UseListAppMain {

    public static void main(String[] args) {
        // 设断点，看看是不是真的跑到了我们刚刚实现的iterator方法里
        printCollection(addElementsToCollection(new MyArrayList<String>()));
    }

    public static Collection addElementsToCollection(Collection<String> collection) {
        for (int i = 0; i < 10; i++) {
            collection.add("str" + (i % 5));
        }
        return collection;
    }

    public static void printCollection(Collection<String> collection) {
        System.out.println();
        System.out.println("输出" + collection.getClass() + "中的元素， 共" + collection.size() + "个");
        try {
            for (Object element : collection) {
                System.out.println(element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
