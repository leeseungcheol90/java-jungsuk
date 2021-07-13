package com.chobo.ch09;

class Point implements Cloneable {
  int x,y;

  Point(int x, int y) {
    this.x=x;
    this.y=y;
  }

  @Override
  public String toString() {
    return "x="+x+", y="+y;
  }

  @Override
  public Object clone() {
    Object obj=null;
    try {
      obj=super.clone();
    } catch (CloneNotSupportedException e) {}
    return obj;
  }

}

public class CloneEx1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Point original=new Point(3,5);
    Point copy=(Point)original.clone();
    System.out.println(original);
    System.out.println(copy);
    System.out.println(original.hashCode());
    System.out.println(copy.hashCode());
  }

}
