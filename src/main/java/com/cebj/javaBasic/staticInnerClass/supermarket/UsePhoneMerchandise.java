package com.cebj.javaBasic.staticInnerClass.supermarket;

public class UsePhoneMerchandise {
  public static void main(String[] args) {
		Phone phone = new Phone(
						"手机001", "Phone001", 100, 1999, 999,
						4.5, 3.5, 4, 128, "索尼", "安卓"
		);
		phone.describePhone();

		// 当然，静态内部类也可以在外部类外部来使用，只是需要加上外部类这个前缀，比如Phone.cpu
		// 静态内部类，可以认为和静态方法、静态成员一样，是类的一个类内部的一个成员，一个组成部分。
		// 所以使用的时候，也可以点进来，只是点出来的是个类而已。点出来以后，该怎么用一个类都行。
		Phone.CPU cpu = new Phone.CPU(5.5, "default");
		// 访问控制：在定义静态内部类的外部的代码，就不可以访问其private属性了，因为speed属性属于CPU的私有成员
		// 它和Phone是一家子，在里面可以互相访问private属性和方法，但是出了Phone就不可以了。
		// cpu.speed;
		Math.random();
  }
}
