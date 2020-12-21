package com.cebj.javaBasic.stringdemo1;

public class LearnString {
    public static void main(String[] args) {
        String content = "01234567ABCDefgh";
        // String的length()是个方法不是属性
        System.out.println(content.length());
        // 其实是生成了新的String对象
        System.out.println(content.toUpperCase());
        System.out.println(content.toLowerCase());

        // content执行对象的内容并没有变化
        System.out.println(content);
        System.out.println(content.charAt(1));

        System.out.println(content.charAt(99));
        System.out.println(content.substring(5));
        System.out.println(content.substring(1,5));
    }
}
