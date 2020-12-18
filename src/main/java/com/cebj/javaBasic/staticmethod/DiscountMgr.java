package com.cebj.javaBasic.staticmethod;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.staticmethod
 * @date 2020/12/18 0018 23:57
 */
public class DiscountMgr {
    public static void main(String[] args) {
        System.out.println("最终main方法中使用的SVIP_DISCOUNT是" + SVIP_DISCOUNT);
    }

    public static double BASE_DISCOUNT;
    public static double VIP_DISCOUNT;
    public static double SVIP_DISCOUNT;

    static {
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.85;
        SVIP_DISCOUNT = 0.75;
        System.out.println("静态代码块1里的SVIP_DISCOUNT为：" + SVIP_DISCOUNT);
    }

    static {
        SVIP_DISCOUNT = 0.1;
        System.out.println("静态代码块2里的SVIP_DISCOUNT为：" + SVIP_DISCOUNT);
    }
}
