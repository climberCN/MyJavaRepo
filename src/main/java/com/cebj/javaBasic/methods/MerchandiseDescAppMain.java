package com.cebj.javaBasic.methods;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.methods
 * @date 2020/12/12 0012 9:54
 */
public class MerchandiseDescAppMain {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise();

        merchandise.name = "书桌";
        merchandise.soldPrice = 999.9;
        merchandise.purchasePrice = 500;
        merchandise.count = 40;
        merchandise.id = "DESK9527";

        System.out.println(
                "商品名字：" + merchandise.name + " "
                        + "id：" + merchandise.id + " "
                        + "商品售价：" + merchandise.soldPrice + " "
                        + "商品进价：" + merchandise.purchasePrice + " "
                        + "商品库存：" + merchandise.count + " "
                        + "单品毛利润：" + (merchandise.soldPrice - merchandise.purchasePrice)
        );
    }
}
