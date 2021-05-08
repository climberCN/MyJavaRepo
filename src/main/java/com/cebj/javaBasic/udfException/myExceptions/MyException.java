package com.cebj.javaBasic.udfException.myExceptions;

public class MyException extends Exception {

	public MyException() {}

	public MyException(String msg) {
		super(msg);
	}

	public MyException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MyException(Throwable cause){
		super(cause);
	}
}
