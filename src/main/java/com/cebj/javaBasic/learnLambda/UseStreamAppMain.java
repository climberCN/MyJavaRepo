package com.cebj.javaBasic.learnLambda;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseStreamAppMain {
    public static void main(String[] args) {
        List<String> myList = IterateListLambdaWhereAppMain.addElementsToList(new ArrayList<>());
        System.out.println("-------------lambda的奥义-----------");
        // lambda的奥义是使用lambda一个接着一个处理，不要停，一路处理下去，直到业务结束
        // 理性来说，lambda结构对计算优化是友好的：感性地说：这种方式会产生一种美，让人感到莫名舒适
        myList.stream().filter(s -> s.length() > 4).map(String::toUpperCase).forEach(System.out::println);

        // 当然也可以使用collector让数据重新生成一个List
        System.out.println("-------------使用collector-----------");
        List<String> longgerStrList = myList.stream().filter(s -> s.length() > 4)
                .map(String::toUpperCase).collect(Collectors.toList());
        longgerStrList.forEach(System.out::println);
    }
}
