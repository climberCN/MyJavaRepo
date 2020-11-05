package com.cebj.Generic;

public class Test {
    public static void main(String[] args) {
//        ArrayList<String> stringArrayList = new ArrayList<String>();
//        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class stringArrayListClass = stringArrayList.getClass();
//        Class integerArrayListClass = integerArrayList.getClass();
//        System.out.println(stringArrayListClass.toString());
//        System.out.println(integerArrayListClass.toString());
//
//        if (stringArrayListClass.equals(integerArrayListClass)) {
//            System.out.println("类型相同");
//        }
        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer
        GenericParadigm<Integer> integerGenericParadigm = new GenericParadigm<Integer>(123456);
        // 传入的实参类型需与泛型的类型参数类型相同，即为String
        GenericParadigm<String> stringGenericParadigm = new GenericParadigm<String>("key_value");
        System.out.println(integerGenericParadigm.getKey());
        System.out.println(stringGenericParadigm.getKey());


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        GenericParadigm genericParadigm1 = new GenericParadigm("1111111");
        GenericParadigm genericParadigm2 = new GenericParadigm(44444);
        GenericParadigm genericParadigm3 = new GenericParadigm(55.55);
        GenericParadigm genericParadigm4 = new GenericParadigm(false);

        System.out.println(genericParadigm1.getKey());
        System.out.println(genericParadigm2.getKey());
        System.out.println(genericParadigm3.getKey());
        System.out.println(genericParadigm4.getKey());

        Generator1<String> stringGenerator1 = new Generator1<String>();
        stringGenerator1.next();
    }
}
