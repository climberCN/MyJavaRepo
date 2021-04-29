package com.cebj.javaBasic.reflect.supermarket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		MerchandiseV2 m2 = new MerchandiseV2();
		Class clazz = m2.getClass();
		Method buy2 = clazz.getDeclaredMethod("buy", int.class);
		buy2.setAccessible(true);
		buy2.invoke(m2, 2);
	}
}
