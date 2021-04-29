package com.cebj.javaBasic.FirstClass;

import com.cebj.javaBasic.FirstClass.supermarket.LittleSuperMarket;
import com.cebj.javaBasic.FirstClass.supermarket.MerchandiseV2;
import com.cebj.javaBasic.FirstClass.supermarket.ShellColorChangePhone;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
  public static void main(String... args) throws NoSuchFieldException, NoSuchMethodException {
		LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
					"世纪大道1号", 500, 600, 100);
		MerchandiseV2 m100 = superMarket.getMerchandiseOf(100);
		Class clazz = m100.getClass();
		// String name, String id, int count, double soldPrice
//  	Method m = clazz.getMethod("MerchandiseV2", String.class, String.class, int.class, double.class);
		Method mGetName = clazz.getMethod("getName");
    System.out.println(mGetName.toString());

		Method mTest = clazz.getMethod("test");
    System.out.println(mTest.toString());
	}
}
