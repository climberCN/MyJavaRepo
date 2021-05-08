package com.cebj.javaBasic.list1.mylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList implements List {

	private Object[] elements;

	private int curr;

	public MyArrayList() {
		elements = new Object[16];
		curr = 0;
	}

	@Override
	public int size() {
		return curr + 1;
	}

	@Override
	public boolean isEmpty() {
		return curr == 0;
	}

	@Override
	public boolean contains(Object o) {
		for (Object ele : elements) {
			if (ele.equals(ele)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator iterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(Object o) {
		if (curr + 1 == elements.length) {
			Object[] tmp = new Object[elements.length * 2];
			System.arraycopy(elements, 0, tmp, 0, elements.length);
			elements = tmp;
		}
		elements[curr] = o;
		curr++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		curr = 0;
	}

	@Override
	public Object get(int index) {
		if (index < 0 || index > curr) {
			throw new IndexOutOfBoundsException("out of bound" + curr + " for " + index);
		}
		return elements[index];
	}

	@Override
	public Object set(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, Object element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray(Object[] a) {
		throw new UnsupportedOperationException();
	}
}
