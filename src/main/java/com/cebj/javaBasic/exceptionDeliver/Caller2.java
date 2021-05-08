package com.cebj.javaBasic.exceptionDeliver;

public class Caller2 {
	Caller3 caller3 = new Caller3();

	public void call3RTException() {
    System.out.println("Caller2.call3RTException 开始");
    caller3.callThrowRTException();
		System.out.println("Caller2.call3RTException 结束");
	}

	public void call3Exception() throws ClassNotFoundException {
    System.out.println("Caller2.call3Exception 开始");
    caller3.callThrowException();
		System.out.println("Caller2.call3Exception 结束");
	}
}
