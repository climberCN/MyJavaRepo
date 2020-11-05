package com.cebj.Generic;

/**
 * implements接口就是在使用接口，使用接口时，如果未传入泛型实参（implements GenericInterface<T>），
 * 与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class Generator1<T> implements GenericInterface<T>
 * 如果在类声明(public class Generator1)中不声明泛型，如：
 * class Generator1 implements GenericInterface<T>   编译器会报错
 *
 * @param <T>
 */
public class Generator1<T> implements GenericInterface<T> {
    @Override
    public T next() {
        return null;
    }
}
