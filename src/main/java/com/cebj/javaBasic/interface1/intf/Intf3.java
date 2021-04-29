package com.cebj.javaBasic.interface1.intf;


// 1.接口也可以继承接口。接口可以继承多个接口，接口之间的继承要用extends
// 2.接口不可以继承类
// 3.继承的接口，可以有重复的方法，但是签名相同时，返回值必须完全一样，否则会有编译错误。
public interface Intf3 extends Intf1, Intf2{
	void m3();
}
