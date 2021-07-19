package com.chobo.ch11;

import java.util.*;

public class MyVector implements List {
  Object[] data=null;
  int size=0;
  int capacity=0;

  MyVector(int capacity) {
    if (capacity<0)
      throw new IllegalArgumentException("유효하지 않은 값입니다. "+capacity);
    this.capacity=capacity;
    data=new Object[capacity];
  }

  public MyVector() {
    this(10);
  }

  @Override
  public void add(int index, Object element) {
    if (capacity>size) {
      if (index <0 || index >=capacity) 
        throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
      else if (index>=size && index<=capacity-1) { 
        data[index]=element;
        size++;
      } else if (index>=0 && index<=size-1) {
        System.arraycopy(data, index, data, index+1, size-index);
        size++;
      }
    } else {
      Object[] tmp=new Object[++capacity];
      if (index <0 || index >=capacity) 
        throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
      System.arraycopy(data, index, tmp, index+1, size-index);
      data=tmp;
      size++;
    }
  }

  public void ensureCapacity(int minCapacity) {
    if (minCapacity>data.length)
      setCapacity(minCapacity);
  }

  @Override
  public boolean add(Object obj) {
    ensureCapacity(size+1);
    data[size++]=obj; // size는 일종의 인덱스?
    return true;
  }

  @Override
  public Object get (int index) {
    if (index <0 || index>=size)
      throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
    return data[index];
  }

  @Override
  public Object remove(int index) {
    Object oldObj=null;

    if (index<0 || index>=size) 
      throw new IndexOutOfBoundsException("범위를 벗어났습니다.");
    oldObj=data[index];

    if (index!=size-1) {
      System.arraycopy(data, index+1, data, index, size-index-1);
    }

    data[size-1]=null;
    size--;
    return oldObj;
  }

  @Override
  public boolean remove(Object obj) {
    for (int i=0;i<size;i++) {
      if (obj.equals(data[i])) {
        remove(i);
        return true;
      }
    }
    return false;
  }

  public void trimToSize() {
    setCapacity(size);
  }

  private void setCapacity(int capacity) {
    if (this.capacity==capacity) return;

    Object[] tmp=new Object[capacity];
    System.arraycopy(data, 0, tmp, 0, size);
    data=tmp;
    this.capacity=capacity;
  }

}
