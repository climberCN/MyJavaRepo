package com.cebj.javaBasic.staticInnerClass.supermarket;

public class Phone extends MerchandiseV2 {
	// 给Phone增加新的属性和方法
	private double screenSize;
	private CPU cpu;
	private int memoryG;
	private int storageG;
	private String brand;
	private String os;

	// 静态内部类，是在类中使用static修饰的类
	// 静态内部类可以有访问控制符。静态内部类和静态方法静态变量一样，都是类的静态组成部分，即该类属于外部类，且只有一份。
	// 静态内部类也是类，在继承、实现接口方面都是一样的。以后不做特殊说明，在这方面都是这样的。
	// 可以看到，我们在Phone这个类中，又定义了一个public static class CPU{}，看起来稍微有点奇怪。这就是静态内部类
	// static代表静态，这个类又定义在Phone类内部，因此就叫静态内部类。即，在类中，使用static修饰的类。
	// 除了位置不一样，其实静态内部类和一般的类没有太多的不同之处。

	// 静态内部类有访问修饰符，这里是public。首先抛去是不是类这个问题，它定义在Phone内，他就是Phone的成员，是成员，就有访问控制符。
	// 我不管你是类也好，方法也好，属性也好。只要你在类里面，是类的一部分，我就可以用访问控制符来控制你是否可以被外部使用。

	// 如果我们暂时不考虑这个类定义在Phone内部，只是单纯看这个CPU类本身，它的代码并没有什么不一样。可以定义成员变量，构造方法，成员方法。
	// 也可以覆盖Object的方法。

	// 当我们定义完静态内部类，我们就可以像一个类一样去使用它。比如说创建它的对象。
	// 当然了，静态内部类有一个特殊的地方，静态内部类，它的代码和类本身的权限一样，可以访问外部类Phone的private属性，因为静态内部类可以
	// 看作外部类Phone的一部分。
	public static class CPU {
		private double speed;
		private String producer;

		public CPU(double speed, String producer) {
			this.speed = speed;
			this.producer = producer;
		}

		private void accessThisTest1(Phone phone){
			phone.cpu = null;
		}

//		private void accessThisTest2() {
//			// 提示错误：Cannot resolve symbol "cpu"
//			this.cpu = null;
//		}

		private void test(){}

		public double getSpeed() {
			// 静态内部类其方法和这个类本身的访问权限一样，可以访问外部（Phone）的private属性
			// 注意：这并不是说它可以访问private变量
			// 静态内部类是静态的，就好像静态方法一样，没有this自引用，可以通过引用访问Phone对象的private属性
			this.speed = 0;
			this.producer = "";
			Phone phone = null;
			phone.memoryG = 99;
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public String getProducer() {
			return producer;
		}

		public void setProducer(String producer) {
			this.producer = producer;
		}

		@Override
		public String toString() {
			return "CPU{" +
							"speed=" + speed +
							", producer='" + producer + '\'' +
							'}';
		}

		// 静态内部类，里面可以有任意合法的类的组成部分，包括静态内部类
		public static class ABC{}
	}

	public void accessStaticInnerClassPrivateField() {
		// 同样，外部类也可以访问静态内部类（CPU）的private属性和private方法
		this.brand = "";
		this.cpu.producer = "";
		this.cpu.test();
	}

	// 总结，静态内部类除了没有父类的this自引用，即不能直接引用父类的属性和方法；另外因为可以看做是外部类的一部分，因此可以
	// 访问外部类的private属性和方法，并且外部类也可以访问静态内部类的private属性和方法。除此之外，和一般类没有差别。

	public Phone(
					String name, String id, int count, double soldPrice, double purchasePrice,
					double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os
	) {

		this.screenSize = screenSize;
		// >> TODO 可以像平常的类一样使用静态内部类
		this.cpu = new CPU(cpuHZ, "Default");
		this.memoryG = memoryG;
		this.storageG = storageG;
		this.brand = brand;
		this.os = os;

		this.setName(name);
		this.setId(id);
		this.setCount(count);
		this.setSoldPrice(soldPrice);
		this.setPurchasePrice(purchasePrice);
	}

	public void describePhone() {

		System.out.println("此手机商品属性如下");
		describe();
		System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
						"屏幕：" + screenSize + "寸\n" +
						"cpu信息：" + cpu + " \n" +
						"内存" + memoryG + "Gb\n" +
						"存储空间" + storageG + "Gb\n");

	}
}

// 非公有类就是说，它不是public class。它的名字可以和文件名不一样
// 它看起来差不多，和静态内部类都是在一个文件里，无非是一个在外部类内部，一个在外部类外部
// 但非公有类不能访问外部类Phone的private属性和方法，反过来也是一样，Phone也不能访问非公有类Memory的private属性和方法。
class Memory {

	private long capacity;
	private String producer;

	public Memory(long capacity, String producer) {
		this.capacity = capacity;
		this.producer = producer;
	}

	public void test(){
		// 在类的外面的代码，不能访问类的private属性
//		Phone ph = null;
//		ph.screenSize = 9;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}
}
