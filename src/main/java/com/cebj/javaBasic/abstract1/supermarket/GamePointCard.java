package com.cebj.javaBasic.abstract1.supermarket;

import java.util.Date;

public class GamePointCard extends AbstractExpireDateMerchandise implements VirtualMerchandise{

	public GamePointCard(
					String name, String id, int count, double soldPrice,
					double purchasePrice, Date produceDate, Date expirationDate
	) {
		super(name, id, count, soldPrice, purchasePrice, produceDate, expirationDate);
	}

	@Override
	public double actualValueNow(double leftDatePercentage) {
		return super.getSoldPrice();
	}
}
