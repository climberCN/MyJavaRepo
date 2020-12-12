package com.cebj.javaBasic.methods;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.methods
 * @date 2020/12/12 0012 11:13
 */
public class MerchandiseV2 {
    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    // 方法的定义：
    // 访问修饰符 返回类型 方法名(参数列表) {方法体}
    // 返回类型：无需返回值则用void表示，void是Java中的关键字
    public void describe() {
        double netIncome = soldPrice - purchasePrice;
        System.out.println(
                "商品名字：" + this.name + " "
                        + "id：" + this.id + " "
                        + "商品售价：" + this.soldPrice + " "
                        + "商品进价：" + this.purchasePrice + " "
                        + "商品库存：" + this.count + " "
                        + "单品毛利润：" + (this.soldPrice - this.purchasePrice)
        );
    }
}
