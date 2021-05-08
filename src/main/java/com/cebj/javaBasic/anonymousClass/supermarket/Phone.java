package com.cebj.javaBasic.anonymousClass.supermarket;

public class Phone extends MerchandiseV2 {
	// 给Phone增加新的属性和方法
	private double screenSize;
	private UnitSpec cpu;
	private UnitSpec memoryG;
	private int storageG;
	private String brand;
	private String os;
	private double speed;


	// 匿名类的语法如下，new后面跟着一个接口或者抽象类
	private UnitSpec anywhere = new UnitSpec() {
		@Override
		public double getNumSpec() {
			return Phone.this.speed;
		}

		@Override
		public String getProducer() {
			return null;
		}
	};

	// 对于抽象类，也可以给构造方法传递参数
	private UnitSpecAbs anywhereAbs = new UnitSpecAbs(1.2, "default") {
		@Override
		public double getNumSpec() {
			return 0;
		}

		@Override
		public String getProducer() {
			return null;
		}
	};
}
