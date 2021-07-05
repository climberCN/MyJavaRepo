package com.cebj.javaBasic.deadlock;

public class AppResources {
    // 系统中有两个或多个资源，如果不按照顺序申请
    // 而是申请到一个后，再申请另一个的时候不释放原来的资源锁，
    // 就可能会发生死锁
    private Object resourcePrinter = new Object();
    private Object resourceInput = new Object();

    public Object getResourcePrinter() {
        return resourcePrinter;
    }

    public Object getResourceInput() {
        return resourceInput;
    }

    public void setResourcePrinter(Object resourcePrinter) {
        this.resourcePrinter = resourcePrinter;
    }

    public void setResourceInput(Object resourceInput) {
        this.resourceInput = resourceInput;
    }
}
