package com.cebj.javaBasic.udfException;

import com.cebj.javaBasic.udfException.myExceptions.MyException;

public class Caller1 {
	Caller2 caller2 = new Caller2();

	public void call2RTException() {
		System.out.println("Caller1.call2RTException开始");
		caller2.call3RTException();
		System.out.println("Caller1.call2RTException结束");
	}

	public void call2Exception() throws MyException {
		System.out.println("Caller1.call2Exception开始");
		caller2.call3Exception();
		System.out.println("Caller1.call2Exception结束");
	}
}
