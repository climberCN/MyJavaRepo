package com.imooc.zhangxiaoxi.lambda.cart;

/**
 * 商品枚举类型
 */
public enum SkuCategoryEnum {
    // enum这里调用的是SkuCategoryenum(Integer code, String name)构造函数,
    // 那enum中的元素究竟是一个对象还是类的属性呢？
    // 为类型定义了4个类
    CLOTHING(10, "服装类"),
    ELECTRONICS(20, "数码类"),
    SPORTS(30, "运动类"),
    BOOKS(40, "图书类");

    // 这里定义了SkuCategoryEnum的属性
    // 商品类型编号
    private Integer code;
    // 商品类型的名称
    private String name;

    // enum的构造函数不带public属性，其构造函数用来生成enum的元素
    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
