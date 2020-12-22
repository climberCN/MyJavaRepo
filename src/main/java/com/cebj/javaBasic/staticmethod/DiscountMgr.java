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

    public static double BASE_DISCOUNT = 0;
    public static double VIP_DISCOUNT = 0;
    // >> TODO 使用某个静态变量的静态代码块必须在静态变量后面
    public static double SVIP_DISCOUNT = 0;

    static {
        BASE_DISCOUNT = 0.99;
        VIP_DISCOUNT = 0.85;
        SVIP_DISCOUNT = 0.75;
        // >> TODO 静态代码块里可以有任意的合法代码，我们想写啥就写啥
        // >> TODO 这段代码在哪个方法中执行呢？<clinit>，即class init。会在每个class初始化的时候被调用一次。
        System.out.println("静态代码块1里的SVIP_DISCOUNT为：" + SVIP_DISCOUNT);
    }

    // >> TODO 其实给静态变量赋值也是放在代码块里的，static代码块可以有多个，是从上至下顺序执行的。
    // >> TODO 可以认为这些代码都被组织到了一个clinit方法里。
    static {
        SVIP_DISCOUNT = 0.1;
        System.out.println("静态代码块2里的SVIP_DISCOUNT为：" + SVIP_DISCOUNT);
    }
}
