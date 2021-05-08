package com.cebj.javaBasic.exception1;

public class ExceptionFirstExpression {
  public static void main(String[] args) {
  	// try语句中如果发生了异常（Exception），那么程序会跳转到catch语句。
		// Java会将异常相关信息封装到一个异常类的实例中，ex是指向这个异常实例的引用
		// "处理"最简单的方法，就是调用printStackTrace将异常信息输出到控制台
		// catch语句执行完毕，程序会继续向下顺序执行
		try {
			int[] arr = new int[1];
			// 这里会发生数组越界异常
			arr[1] = 9;
		} catch (Exception ex) {
			int abc = 999;
			ex.printStackTrace();
		}


		try {
			String str = "";
			str.substring(9, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}

    System.out.println("程序执行结束");
  }
}
