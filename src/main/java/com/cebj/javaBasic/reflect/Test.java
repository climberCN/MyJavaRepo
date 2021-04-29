package com.cebj.javaBasic.reflect;

import com.cebj.javaBasic.reflect.supermarket.LittleSuperMarket;
import com.cebj.javaBasic.reflect.supermarket.MerchandiseV2;
import com.cebj.javaBasic.reflect.supermarket.Phone;
import com.cebj.javaBasic.reflect.supermarket.ShellColorChangePhone;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
  public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		LittleSuperMarket superMarket = new LittleSuperMarket("大卖场",
						"世纪大道1号", 500, 600, 100);
		// 准备对象
		ShellColorChangePhone colorChangePhone = new ShellColorChangePhone("Mate40", "123", 10, 3000.2, 2000.2, 3.5, 3.5, 2048, 4096, "华为", "鸿蒙");
		Phone phone = new Phone("Mate40", "456", 15, 3000.2, 2000.2, 3.5, 2.8, 2048, 4096, "华为", "鸿蒙");
		MerchandiseV2 merchandiseV2 = new MerchandiseV2();
		Class colorPhoneClz = colorChangePhone.getClass();
		Class phoneClz = phone.getClass();
		Class mClz = merchandiseV2.getClass();
		Method descColorPhone = colorPhoneClz.getMethod("describe");
		Method descPhone = phoneClz.getMethod("describe");
		Method descM = mClz.getMethod("describe");

		// 1.使用子类方法invoke
//		descColorPhone.invoke(colorChangePhone);
//		descColorPhone.invoke(phone);
//		descColorPhone.invoke(merchandiseV2);

		// 2.使用父类方法invoke
		descM.invoke(colorChangePhone);
    System.out.println();
		descM.invoke(phone);
    System.out.println();
		descM.invoke(merchandiseV2);
	}
}
