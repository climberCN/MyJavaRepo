package com.cebj.javaBasic.tryCatchFinally;

public class TryFinallyAppMain {

	private static int VAL = 0;

	public static void main(String[] args) {
    System.out.println(withFinally());
    System.out.println(VAL);
	}

	private static int withFinally() {
		int len = 0;
		try {
			String s = null;
			return s.length();
		} finally {
      System.out.println("执行finally语句");
			VAL = 999;
		}
	}
}
