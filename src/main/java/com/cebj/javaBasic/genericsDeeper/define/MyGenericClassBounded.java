package com.cebj.javaBasic.genericsDeeper.define;

import com.cebj.javaBasic.learnGeneric.ext.GrandParent;

public class MyGenericClassBounded<MyType extends GrandParent> {
    // 实际上这个引用是GrandParent类型的
    private MyType myType;

    public MyGenericClassBounded(MyType myType) {
        // 所以这里可以通过这个引用，调用GrandParent的方法
        myType.getNum();
        this.myType = myType;
    }

    public void setMyType(MyType myType) {
        this.myType = myType;
    }
}
