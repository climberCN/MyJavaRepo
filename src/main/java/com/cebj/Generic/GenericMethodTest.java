package com.cebj.Generic;

import java.util.ArrayList;

public class GenericMethodTest {
    public class GenericParadigm<T> {
        // key这个成员变量的类型为T，T的类型由外部指定
        private T key;

        public GenericParadigm(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }

        /**
         * 想说的其实是这个，虽然在方法中使用了泛型，但是这并不是一个泛型方法。
         * 这只是类中一个普通的成员方法，只不过它的返回值是在声明泛型类已经声明过的泛型
         * 所以在这个方法中，才可以继续使用T这个泛型
         * @return
         */
        public T getKey() { // 泛型方法getKey()的返回值类型为T，T的类型由外部指定。
            return key;
        }

        /**
         * 这个方法显然是有问题的，编译器会给我们这样的提示信息"cannot resolve symbol E"
         * 因为在类的声明中并未声明泛型E，所以在使用E做形参和返回值类型时，编译器无法识别。
         * @param key
         * @return
         */
//        public E setKey(E key) {
//            this.key = key;
//        }
    }


    /**
     * 这才是一个真正的泛型方法。
     * 首先public和返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置
     * 泛型的数量也可以为任意多个。
     * 如： public <T,K> K showKeyName(GenericParadigm<T> container) {
     *      ...
     *      }
     * 这与泛型类中使用泛型的普通方法的差别在于：
     * 这里泛型是没有类定义的，而是方法定义的。这样的方法叫做泛型方法。
     * 其中泛型可以定义多个。
     *
     * 这里定义的泛型T和上面定义的泛型类没有任何关系。
     * 其泛型使用的就是public 和 T中间定义的泛型。该泛型函数中可以使用的就是<T>中定义的泛型T
     */
    public <T> T showKeyValue(ArrayList<T> container) {
        T test = container.get(0);
        return test;
    }

    /**
     * 这也不是一个泛型方法，这就是一个普通方法，只是使用了GenericParadigm<Number>这个泛型类做形参而已
     * @param obj
     */
    public void showKeyValue1(GenericParadigm<Number> obj) {
        System.out.println("key value is " + obj.getKey());
    }

    /**
     * 这也不是一个泛型方法，这就是一个普通方法，只是使用了泛型通配符？
     * 同时这也验证了，？是一种类型实参，可以看做Number等所有类的父类
     * @param obj
     */
    public void showKeyValue2(GenericParadigm<?> obj) {
        System.out.println("key value is " + obj.getKey());
    }

    /**
     * 这个方法也是有问题的，编译器提示Cannot resolve symbol 'E'
     * 我们虽然声明了<T>这个泛型方法，也声明了泛型T类型
     * 但是只声明了泛型T，但是并没有声明泛型E，因此编译器不知道如何处理E这个类型
     * @param container
     * @param <T>
     * @return
     */
//    public <T> T showKeyValue3(GenericParadigm<E> container) {
//        pass
//    }

    /**
     * 对于编译器来说T这个类型并未在项目中声明过，因此编译也不知道该如何编译这个类
     * 所以，这也不是一个泛型方法
     * @param obj
     */
//    public void showKey(T obj) {
//        ...
//    }
}
