package com.cebj.javaBasic.exception1;

public class ImplIntWithEx implements IntWithEx {

	@Override
	public void danger(){
		// 接口中声明了抛出异常，实现类中可以抛，也可以不抛。抛的话，必须是接口声明的异常类本身或其子类
		try {
			throw new ClassNotFoundException("");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public void danger() throws Exception{
//		// 不报错
//		throw new ClassNotFoundException("");
//	}
//
//	@Override
//	public void danger() throws ClassNotFoundException{
//		// 不报错
//		throw new ClassNotFoundException("");
//	}

	@Override
	public void safe() {
		// 接口中没有声明抛出异常，实现类中可以抛RuntimeException，也可以不抛。
		// 如果抛checked exception 就会出错
		// 可以选择catch住 checked exception , 然后将其封在RuntimeException里
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}

//	@Override
//	public void safe() throws Exception {
//		// 报错overridden method does not throw 'java.lang.Exception'
//		throw new Exception();
//	}
//
//	@Override
//	public void safe() throws RuntimeException {
//		// 不报错
//		throw new RuntimeException();
//	}
//
//	@Override
//	public void safe(){
//		// 不报错
//		throw new RuntimeException();
//	}
//
//	@Override
//	public void safe(){
//		// 不报错
//		try {
//		  throw new RuntimeException();
//		} catch (RuntimeException re) {
//			re.printStackTrace();
//		}
//	}
}
