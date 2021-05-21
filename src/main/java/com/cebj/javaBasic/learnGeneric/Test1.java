package com.cebj.javaBasic.learnGeneric;

import java.util.ArrayList;

public class Test1 {
  public static void main(String[] args) {
  	ArrayList<String> strs = new ArrayList<>();
  	// 当使用泛型后，Java会检查我们存入的类型是否是泛型对应的类型
//  	strs.add(new Object());
  	strs.add("a");
		strs.add("b");
		strs.add("c");
		for (int i = 0; i < strs.size(); i++) {
			// 在使用泛型后，虽然容器类中还是存储的Object，但由于存在泛型，
			// 因此Java会把元素在底层强转为泛型指定的类型，比如这里的String
			// 因此，我们就可以直接把元素拿来当做String使用了
      System.out.println(strs.get(i).toUpperCase());
		}
	}
}
