package com.cebj.javaBasic.udfException;

public class CallerRtExceptionAppMain {
  public static void main(String[] args) {
		Caller1 caller1 = new Caller1();
		System.out.println("调用开始");
		caller1.call2RTException();
		System.out.println("调用结束");
  }
}
