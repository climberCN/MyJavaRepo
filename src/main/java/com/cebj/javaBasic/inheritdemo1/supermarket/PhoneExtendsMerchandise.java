package com.cebj.javaBasic.inheritdemo1.supermarket;

// >> TODO 继承，其实表达的是一种“is-a”关系，也就是说，在你用类构造的世界中，“子类是父类的一种特殊类别”
// >> TODO 继承和组合，是拿到一个问题，是拿到一个问题，设计相应的Java类的时候，不得不面对的来自灵魂的拷问
// >> TODO XX到底是YY的一种，还是只是组合了YY？手机到底是是手电筒的一种，还是组合了一个可以当手电的闪光灯？

// >> TODO 在组合的情况下，怎么限制一次只能买5个手机呢？
// >> TODO 1.首先不能修改MerchandiseV2这个类，否则你会限制所有商品一次购买的数量
// >> TODO 2.其次，在现实的情况下，这个类可能根本不受你控制，你无权修改其代码
// >> TODO 3.在每次调用buy方法的地方做限制，是不行的。
//        TODO - 你无法控制别人怎么用你的类
//        TODO - 而且会面临到处复制代码的糟糕情况
//        TODO - 如果说限制改成10个，所有复制的代码都要改，程序员都应该很懒，这不是一个程序员该做的事情。
// >> TODO 在只能修改手机类的情况下，我们可以提供一个buyPhone的方法，实现限制购买数量的逻辑。

public class PhoneExtendsMerchandise extends MerchandiseV2 {
}
