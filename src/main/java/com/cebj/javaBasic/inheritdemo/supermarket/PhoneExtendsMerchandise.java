package com.cebj.javaBasic.inheritdemo.supermarket;


// >> TODO 继承的语法就是在类名后面使用extends加 要继承的类名
// >> TODO 被继承的类叫做父类，比如本例中的MerchandiseV2
// >> TODO 继承者叫做子类，比如本例中的PhoneExtendsMerchandis
// >> TODO Java中只允许一个类有一个直接的父类，即所谓的单继承
// >> TODO 没错，别的类也可以继承子类，比如可以有一个HuaWeiPhone继承PhoneExtendsMerchandise
// >> TODO 这时候，HuaweiPhone就是PhoneExtendsMerchandise的子类了
// >> TODO 子类继承了父类什么呢？所有的属性和方法
// >> TODO 但是子类并不能访问父类的private成员（包括方法和属性）
public class PhoneExtendsMerchandise extends MerchandiseV2{
    // 给Phone增加新的属性和方法
    private double screenSize;
    private double cpuHZ;
    private int memoryG;
    private int storageG;
    private String brand;
    private String os;

    public PhoneExtendsMerchandise(
            String name, String id, int count, double soldPrice, double purchasePrice,
            double screenSize, double cpuHZ, int memoryG, int storageG, String brand, String os
    ) {
        this.screenSize = screenSize;
        this.cpuHZ = cpuHZ;
        this.memoryG = memoryG;
        this.storageG = storageG;
        this.brand = brand;
        this.os = os;

        this.setName(name);
        this.setId(id);
        this.setCount(count);
        this.setSoldPrice(soldPrice);
        this.name = name;
//        this.purchasePrice = purchasePrice;
        this.setPurchasePrice(purchasePrice);
    }

    public void describePhone() {
        System.out.println("此手机商品属性如下：");
        this.describe();
        System.out.println("手机厂商为" + brand + "；系统为" + os + "；硬件配置如下：\n" +
                "屏幕：" + screenSize + "寸\n" +
                "cpu主频" + cpuHZ + " GHz\n" +
                "内存" + memoryG + "Gb\n" +
                "存储空间" + storageG + "Gb\n");
    }

    public void callParentMethodWithThis(){
        this.calculateProfit();
        this.setSoldPrice(50.3);
        this.buy(10);
        this.describe();
    }

    public void callParentMethod() {
        calculateProfit();
        setSoldPrice(50.3);
        buy(10);
        describe();
    }

    public void callParentFieldsWithThis() {
        System.out.println(this.name);
        System.out.println(this.id);
        System.out.println(this.soldPrice);
//        System.out.println(this.purchasePrice);
    }

    public void callParentFileds(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(soldPrice);
//        System.out.println(purchasePrice);
    }

    public boolean meetCondition() {
        return true;
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
