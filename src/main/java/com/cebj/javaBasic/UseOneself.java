package com.cebj.javaBasic;

public class UseOneself {
    private UseOneself uo;

    public UseOneself() {
        uo = new UseOneself();
    }

    public static void main(String[] args) {
        UseOneself uo = new UseOneself();
    }
}
