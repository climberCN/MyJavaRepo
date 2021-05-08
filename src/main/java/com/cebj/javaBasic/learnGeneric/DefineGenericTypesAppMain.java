package com.cebj.javaBasic.learnGeneric;

import com.cebj.javaBasic.learnGeneric.define.MyGenericClass;
import com.cebj.javaBasic.learnGeneric.ext.GrandParent;
import com.cebj.javaBasic.learnGeneric.ext.Parent;

import java.lang.reflect.Field;

// 泛型的作用包括：1.告诉编译器帮我们检查类型是否匹配，类型是什么不重要，类型一样才重要
// 2.在使用的地方悄悄地帮我们做类型强制转换
public class DefineGenericTypesAppMain {
  public static void main(String[] args) throws NoSuchFieldException {
		Field firstTmp = MyGenericClass.class.getDeclaredField("first");
    System.out.println("first的类型是" + firstTmp.getType());

    MyGenericClass<String, Object> test = new MyGenericClass<>("inst1", new Object());
    MyGenericClass<String, Object> test2 = new MyGenericClass<>("inst2", "aaabbb");

    String first = test.getFirst();
    System.out.println(first);
//    String second = test.getSecond();

		// 方法的类型参数也是一样，换到了使用的地方做类型强制转换
		String another = test.getAnother("sage");
		String another1 = test.getAnother(new Object());
		String another2 = (String) test.getAnother(new Object());

		// 如果泛型信息缺失了，编译器也无法帮忙检查出类型不匹配，只能给出unchecked编译警告
		MyGenericClass mc = new MyGenericClass("", "");
		MyGenericClass<GrandParent, Parent> cast = mc;

		// 会出错，因为cast指向的实例其实里面存的是两个String
		GrandParent a = cast.getFirst();
		// 只调用这个方法，不会出错
		cast.getFirst();
	}
}
