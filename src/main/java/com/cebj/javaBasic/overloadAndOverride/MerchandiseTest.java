package com.cebj.javaBasic.overloadAndOverride;

import com.cebj.javaBasic.overloadAndOverride.supermarket.MerchandiseV2;
import com.cebj.javaBasic.overloadAndOverride.supermarket.Phone;
import com.cebj.javaBasic.overloadAndOverride.supermarket.ShellColorChangePhone;

/**
 * @author zjh
 * @version V1.0
 * @Package com.cebj.javaBasic.overloadAndOverride.supermarket
 * @date 2021/1/9 0009 22:18
 */
public class MerchandiseTest {
    // TODO 之前重载的时候，参数是用的是基本数据类型。现在理解了父类和子类的引用赋值关系，重载又多了一层复杂性。
    public void testMerchandiseOverload(MerchandiseV2 me) {
        System.out.println("参数为MerchandiseV2的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(Phone ph) {
        System.out.println("参数为Phone的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(ShellColorChangePhone shellColorChangePhone) {
        System.out.println("参数为ShellColorChangePhone的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverload(String str) {
        System.out.println("参数为String的testMerchandiseOverload 被调用了");
    }

    public void testMerchandiseOverloadNotExactlyMatchType(MerchandiseV2 me) {
        System.out.println("参数为MerchandiseV2的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }
    public void testMerchandiseOverloadNotExactlyMatchType(Phone ph) {
        System.out.println("参数为Phone的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }

    public void testMerchandiseOverloadNotExactlyMatchType(String str) {
        System.out.println("参数为String的testMerchandiseOverloadNotExactlyMatchType 被调用了");
    }
}
