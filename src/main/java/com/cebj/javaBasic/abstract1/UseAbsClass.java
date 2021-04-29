package com.cebj.javaBasic.abstract1;

import com.cebj.javaBasic.abstract1.supermarket.AbstractExpireDateMerchandise;
import com.cebj.javaBasic.abstract1.supermarket.GamePointCard;

import java.util.Date;

public class UseAbsClass {

	public static void main(String[] args) {
		Date produceDate = new Date();
		Date expireDate = new Date(produceDate.getTime() + 365L * 24 * 3600 * 1000);
		GamePointCard gamePointCard = new GamePointCard(
						"点卡001", "点卡001", 100, 1999, 999,
						produceDate, expireDate
		);

		// >> TODO 父类的引用可以用子类的引用赋值，抽象类也一样
		AbstractExpireDateMerchandise am = gamePointCard;

		am.describe();
  }

}
