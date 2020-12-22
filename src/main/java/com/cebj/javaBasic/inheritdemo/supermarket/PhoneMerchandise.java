package com.cebj.javaBasic.inheritdemo.supermarket;

public class PhoneMerchandise {
    // 给Phone增加新的属性和方法

    private double screenSize;
    private double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;


    // 我们要从商品类里复制所有的方法和属性，因为这是一个商品最基础的属性和操作
    private String name;
    private String id;
    private int count;
    private double soldPrice;
    private double purchasePrice;


    public PhoneMerchandise(String name, String id, int count, double soldPrice, double purchasePrice,
                            double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;
    }

    public void describe() {
        System.out.println("商品名字叫做" + name + "，id是" + id + "。 商品售价是" + soldPrice
                + "。商品进价是" + purchasePrice + "。商品库存量是" + count +
                "。销售一个的毛利润是" + (soldPrice - purchasePrice) +
                "手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
                "屏幕：" + screenSize + "寸\n" +
                "cpu主频" + cpuHZ + " GHz\n" +
                "内存" + memoryG + "Gb\n" +
                "存储空间" + storageG + "Gb\n");
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }

    public double buy(int count) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;

        return count * soldPrice;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getCpuHZ() {
        return cpuHZ;
    }

    public void setCpuHZ(double cpuHZ) {
        this.cpuHZ = cpuHZ;
    }

    public int getMemoryG() {
        return memoryG;
    }

    public void setMemoryG(int memoryG) {
        this.memoryG = memoryG;
    }

    public int getStorageG() {
        return storageG;
    }

    public void setStorageG(int storageG) {
        this.storageG = storageG;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
