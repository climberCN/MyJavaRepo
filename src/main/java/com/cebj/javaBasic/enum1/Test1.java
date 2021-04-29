package com.cebj.javaBasic.enum1;

import com.cebj.javaBasic.enum1.supermarket.Category;

public class Test1 {
  public static void main(String[] args) {
		Category food = Category.valueOf("FOOD");
    System.out.println(food.toString());
    System.out.println("***************************");
    for (Category category : Category.values()) {
      System.out.println(category.toString());
      System.out.println(category.name());
      System.out.println(category.ordinal());
      System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}
	}
}
