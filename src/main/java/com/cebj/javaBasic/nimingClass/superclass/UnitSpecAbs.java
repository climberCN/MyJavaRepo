package com.cebj.javaBasic.nimingClass.superclass;

public abstract class UnitSpecAbs {

    private double spec;
    private String producerStr;

    public UnitSpecAbs(double spec, String producerStr) {
        this.spec = spec;
        this.producerStr = producerStr;
    }

    public abstract double getNumSpec();

    public abstract String getProducer();

    public double getSpec() {
        return spec;
    }

    public String getProducerStr() {
        return producerStr;
    }
}
