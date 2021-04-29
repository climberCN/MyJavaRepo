package com.cebj.javaBasic.reflect;

import com.cebj.javaBasic.reflect.supermarket.MerchandiseV2;

import java.lang.reflect.Field;

public class Test4 {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		MerchandiseV2 merchandiseV2 = new MerchandiseV2();
		Class clazz = merchandiseV2.getClass();
		Field staticMember = clazz.getDeclaredField("STATIC_MEMBER");
		staticMember.setAccessible(true);
		String s = (String) staticMember.get(null);
    System.out.println(s);
	}
}
