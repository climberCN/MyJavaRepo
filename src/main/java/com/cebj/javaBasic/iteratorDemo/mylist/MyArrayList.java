package com.cebj.javaBasic.iteratorDemo.mylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] elements;
    private int curr;

    public MyArrayList() {
        elements = new Object[16];
        curr = 0;
    }

    @Override
    public int size() {
        return curr;
    }

    @Override
    public boolean isEmpty() {
        return curr == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object ele : elements) {
            if (Objects.equals(ele, o)) {
                return true;
            }
        }
        return false;
    }

    // 实现 Iterable 接口里定义的iterator接口
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;

            @Override
            public boolean hasNext() {
                return pointer < size();
            }

            @Override
            public T next() {
                return (T) elements[pointer++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    // 使用泛型之后，在实现接口的时候，用泛型代替原来的Object
    @Override
    public boolean add(T t) {
        if (curr == elements.length - 1) {
            elements = new Object[elements.length * 2];
        }
        elements[curr] = t;
        curr++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        curr = 0;
    }

    //SuppressWarnings注解是源码级别的，告诉编译器哪个编译警告我们已经知晓了
    // 不用在编译的时候报出来了
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if (index > curr || index < 0) {
            throw new IndexOutOfBoundsException("out of bound" + curr + " for " + index);
        }
        return (T) elements[index];
    }

    // 使用泛型之后，在实现接口的时候，用泛型代替原来的Object
    @Override
    public T set(int index, T element) {
        if (index > curr || index < 0 ){
            throw new IndexOutOfBoundsException("out of bound" + curr + " for " + index);
        }
        elements[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
