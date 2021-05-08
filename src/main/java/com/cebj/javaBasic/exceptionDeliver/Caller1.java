package com.cebj.javaBasic.exceptionDeliver;

public class Caller1 {
	Caller2  caller2 = new Caller2();

	// 我们可以在调用链的任何一个地方，通过catch语句来捕获异常，组织异常的传递

	public void call2RTException() {
    System.out.println("Caller1.call2RTException 开始");
    caller2.call3RTException();
		System.out.println("Caller1.call2RTException 结束");
	}

	public void call2Exception(){
    System.out.println("Caller1.call2Exception 开始");
		try {
			caller2.call3Exception();
		} catch (ClassNotFoundException e) {
      System.out.println("在Caller1中捕获到异常：" + e.getMessage());
		}
		System.out.println("Caller1.call2Exception 结束");
	}
}
