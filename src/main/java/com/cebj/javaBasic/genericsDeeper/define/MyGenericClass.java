package com.cebj.javaBasic.genericsDeeper.define;

public class MyGenericClass<First, Second> {

    private First first;
    private Second second;

    public MyGenericClass(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() {
        return first;
    }

    public void setFirst(First first) {
        this.first = first;
    }

    public Second getSecond() {
        return second;
    }

    public void setSecond(Second second) {
        this.second = second;
    }


    public <Another> Another getAnother(Object val) {
        return (Another) val;
    }
}
