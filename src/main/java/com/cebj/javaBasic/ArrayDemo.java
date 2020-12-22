package com.cebj.javaBasic;


public class ArrayDemo {
    public static void main(String[] args) {
        // 这里我们使用Merchandise[]定义了数组的类型，类似于int[], 而merchandises就是我们的引用。
        // 又使用new Merchandise[10]来定义对象，即一个数组对象。
        Merchandise[] merchandises = new Merchandise[10];
        // 那这里merchandises[0]其实就代表一个引用，而该引用这里指向了一个new Merchandise();
        // 引用数组（有别于基本数据类型数组）里面存储的是引用，引用的值存储的是一个指针，指向一个对象。
        // 而基本数据类型的变量名指向的就是值。
        merchandises[0] = new Merchandise();
        merchandises[1] = new Merchandise();
        merchandises[0].name = "笔记本";
        System.out.println(merchandises[0].name);
        System.out.println(merchandises[2]);
        int[] arr = new int[10];
        for (int t : arr) {
            System.out.println(t);
        }
    }
}

class Merchandise {
    String name;
    double price;
    int num;

    public void sayHi(){
        System.out.println("Hi!");
    }
}
