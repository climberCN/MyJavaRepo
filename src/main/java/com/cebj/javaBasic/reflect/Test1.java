package com.cebj.javaBasic.reflect;

import com.cebj.javaBasic.reflect.supermarket.MerchandiseV2;

import java.lang.reflect.Field;

public class Test1 {
  public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
		MerchandiseV2 merchandiseV2 = new MerchandiseV2();
		Class clazz = merchandiseV2.getClass();
		Field static_member = clazz.getField("STATIC_MEMBER");
		System.out.println((String)static_member.get(null));
	}
}
