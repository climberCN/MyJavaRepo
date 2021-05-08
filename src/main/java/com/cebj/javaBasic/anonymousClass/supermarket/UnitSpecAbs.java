package com.cebj.javaBasic.anonymousClass.supermarket;

public abstract class UnitSpecAbs implements UnitSpec{
	private double spec;
	private String producerStr;

	public UnitSpecAbs(double spec, String producer) {
		this.spec = spec;
		this.producerStr = producer;
	}

	public double getSpec() {
		return spec;
	}

	public String getProducerStr() {
		return this.producerStr;
	}
}
