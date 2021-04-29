package com.cebj.javaBasic.reflect.supermarket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		MerchandiseV2 merchandiseV2 = new MerchandiseV2();
		Class clazz = merchandiseV2.getClass();
		Method getNameOf = clazz.getMethod("getNameOf", String.class);
		System.out.println(getNameOf.invoke(null, "test"));
	}
}
