package com.cebj.javaBasic.udfException;

import com.cebj.javaBasic.udfException.myExceptions.MyException;

public class CallerExceptionAppMain {
  public static void main(String[] args) throws MyException {
		// catch 语句是根据异常类型匹配来捕捉相应类型的异常的
		// 如果类型不匹配，catch语句时不会执行的，异常会继续抛出
		// 也就是说，catch(Throwable)会捕捉到所有异常，包括Error，建议最多只捕捉到Exception
		// 如果catch一个其实并没有抛出的checked exception,Java程序会报错
		// 因为Java明确知道这个异常不会发生
		// 如果catch一个unchecked exception,Java程序不会报错
		// 如果throws一个其实并没有被抛出的checked exception或者unchecked exception,Java程序不会报错
		Caller1 caller1 = new Caller1();
		System.out.println("调用开始");

		caller1.call2Exception();

		System.out.println("调用结束");
  }
}
