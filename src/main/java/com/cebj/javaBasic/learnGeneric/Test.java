package com.cebj.javaBasic.learnGeneric;

import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
		List ret = new ArrayList();
		ret.add(0);
		ret.add("test");
		ret.add(new ArrayList<String>());
		for (int i =0; i < ret.size(); i++) {
      System.out.println(ret.get(i).getClass());
      System.out.println(ret.get(i));
      System.out.println();
		}
  }
}
