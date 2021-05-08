package com.cebj.javaBasic.udfException;

import com.cebj.javaBasic.udfException.myExceptions.MyException;
import com.cebj.javaBasic.udfException.myExceptions.MyRuntimeException;

public class Caller3 {
	// 可以将checked exception包装成unchecked exception,反之也可以
	public void callThrowRTException() {
		// 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
		System.out.println("Caller3.callThrowRTException开始");
		try {
			Object n = null;
			n.toString();
		} catch (Exception ex) {
			throw new MyRuntimeException("执行callThrowRTException出错", ex);
		}
		System.out.println("Caller3.callThrowRTException结束");
	}

	public void callThrowException() throws MyException {
		// 可以在这里catch异常，然后封装成自己的异常，并增加相应的异常描述
		System.out.println("Caller3.callThrowException开始");
		try {
			Class.forName("com.neverland.Rabbit");
		} catch (ClassNotFoundException ex) {
			throw new MyException("将ClassNotFoundException转换为MyException", ex);
		}
		System.out.println("Caller3.callThrowException结束");
	}
}
