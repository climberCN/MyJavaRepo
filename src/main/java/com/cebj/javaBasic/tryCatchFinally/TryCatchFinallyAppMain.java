package com.cebj.javaBasic.tryCatchFinally;

public class TryCatchFinallyAppMain {

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
		} catch (Exception e) {
			// 异常的处理：在有返回值的情况下，返回一个特殊的值，代表情况不对，有异常
			len = -1;
			System.out.println("执行catch里的return语句");
			return len;
		} finally {
      System.out.println("执行finally语句");
//			len = -2;
			return -2;
		}
	}
}
