package com.imooc.zhangxiaoxi.lambda.cart;

/**
 * 下单商品信息
 */
public class Sku {
    private Integer skuId;
    private String skuName;
    private Double skuPrice;
    private Integer totalNum;
    private Double totalPrice;
    // 定义了枚举作为商品标识
    private Enum skuCateggory;

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCateggory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCateggory = skuCateggory;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public Double getSkuPrice() {
        return skuPrice;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Enum getSkuCateggory() {
        return skuCateggory;
    }
}
