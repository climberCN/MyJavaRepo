package com.cebj.javaBasic.enum1;

import com.cebj.javaBasic.enum1.supermarket.Category;
import com.cebj.javaBasic.enum1.supermarket.LittleSuperMarket;
import com.cebj.javaBasic.enum1.supermarket.MerchandiseV2;
import com.cebj.javaBasic.enum1.supermarket.Phone;

import static com.cebj.javaBasic.enum1.supermarket.Category.FOOD;

public class LittleSupperMarketAppMain {
  public static void main(String[] args) {
		MerchandiseV2 m = new MerchandiseV2("无名", "000", 0, 1, 1.1, Category.FOOD);
//		MerchandiseV2 m = new MerchandiseV2("无名", "000", 0, 1, 1.1, FOOD);
		Phone phone = new Phone("Mate40",
										"456",
										15,
										3000.2,
										2000.2,
										3.5,
										2.8,
										2048,
										4096,
										"华为",
										"鸿蒙",
										Category.FOOD);
		System.out.println(phone.isCategoryEqual(m));
	}
}
