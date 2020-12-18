package com.cebj.javaBasic.staticmethod;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.staticmethod
 * @date 2020/12/18 0018 22:51
 */
public class RunLittleSupperMarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket = new LittleSuperMarket(
                "有家小超市", "浦东新区世纪大道666号",
                100, 200, 200);
        System.out.println("VIP的折上折折扣最终为：" + MerchandiseV2.getDiscountOnDiscount(littleSuperMarket));
    }
}
