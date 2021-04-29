package com.cebj.javaBasic.interface1;

import com.cebj.javaBasic.interface1.supermarket.ExpireDateMerchandise;
import com.cebj.javaBasic.interface1.supermarket.GamePointCard;
import com.cebj.javaBasic.interface1.supermarket.MerchandiseV2;
import com.cebj.javaBasic.interface1.supermarket.VirtualMerchandise;

import java.util.Date;
// 理解：接口也是类型，枚举也是类型，类也是类型，类型就可以有引用。我们可以让接口的引用指向实现类的对象。
// Java里认为，我们继承一个类，实现一个接口，我们都是获得了这样一个类型。在Java中，一个类可以同时有多种类型。
// 比如说GamePointCard类型，其继承了MerchandiseV2，而MerchandiseV2又继承了Object，所以说GamePointCard即是MerchandiseV2类型
// 也是Object类型。同时其实现了两个接口，所以其即是一个ExpireDateMerchandise类型，也是一个VirtualMerchandise类型。
// 我们可以让该类属于的所有的类型的引用指向该类的实例。但注意，引用决定了可以调用的方法和访问的属性，如果引用是ExpireDateMerchandise
// 类型，那么就只能调用该类型的方法。
public class UseInterface {
  public static void main(String[] args) {

  	// 生产日期是当天，过期日期是一年以后，这就是这个点卡商品，同时他也是一个会过期的商品，还是一个虚拟商品
  	Date produceDate = new Date();
		Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);

		// 这里我们用类的引用指向类的实例，该引用决定了其可以调用的方法以及访问的属性是GamePointCard类以及其父类定义的属性和方法
		GamePointCard gamePointCard = new GamePointCard("手机001", "Phone001", 100, 1999, 999,
						produceDate, expireDate);

		// 可以用实现接口的类的引用，给接口的引用赋值。类似于可以使用子类的引用给父类赋值
		// 这里用接口的引用指向类的实例，该引用决定了其可以调用的方法是接口定义的方法。
		ExpireDateMerchandise expireDateMerchandise = gamePointCard;

		// 这里用接口的引用指向类的实例，因为该接口没有定义方法，所以该引用除了调用Object的引用外，什么都调用不了
		VirtualMerchandise virtualMerchandise = gamePointCard;

		MerchandiseV2 m = gamePointCard;

		// 因为m是GamePointCard的实例，其可以进行强制类型转换，转换成其属于的类型。比如这里的ExpireDateMerchandise和VirtualMerchandise
		expireDateMerchandise = (ExpireDateMerchandise) m;

		virtualMerchandise = (VirtualMerchandise) m;

		// 同时该实例也同时都是这MerchandiseV2，Object，ExpireDateMerchandise，VirtualMerchandise这4种类型
		if (m instanceof ExpireDateMerchandise) {
			System.out.println("m 是 ExpireDateMerchandise 类型的实例");
		}
		if (m instanceof  VirtualMerchandise) {
			System.out.println("m 是 VirtualMerchandise 类型的实例");
		}
	}
}
