package com.cebj.javaBasic.exception1;

public class NewAndThrowIt {
  public static void main(String[] args) throws Exception{
  	// 报错Unhandled exception: java.lang.Exception
		causeException();
  }

  public static void causeException() throws Exception {
  	// 可以创建一个checked exception, 然后用throw关键字扔出去
		// 这时候就需要方法也要有throws语句，同样的，throws语句的类型要能覆盖实际异常的类型
		throw new Exception("测试");
	}
}
