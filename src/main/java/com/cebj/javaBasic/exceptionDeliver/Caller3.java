package com.cebj.javaBasic.exceptionDeliver;

public class Caller3{
	public void callThrowRTException() {
		System.out.println("Caller3 callThrowRTException 开始");
		Object o = null;
		o.toString();
		System.out.println("Caller3 callThrowRTException 结束");
	}

	public void callThrowException() throws ClassNotFoundException {
		System.out.println("Caller3 callThrowException 开始");
		Class.forName("com.neverland.Rabbit");
		System.out.println("Caller3 callThrowException 结束");
	}
}
