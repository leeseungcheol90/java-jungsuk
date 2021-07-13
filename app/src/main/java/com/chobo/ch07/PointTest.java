package com.chobo.ch07;

public class PointTest {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Point3D p3=new Point3D(1,2,3);
  }
}

class Point {
  int x,y;

  Point(int x,int y) {
    this.x=x;
    this.y=y;
  }

  String getLocation() {
    return "x :"+x+", y :"+y;
  }
}

class Point3D extends Point {
  int z;

  Point3D(int x,int y,int z) {
    this.x=x;
    this.y=y;
    this.z=z;
  }

  @Override
  String getLocation() {
    return "x :"+x+", y :"+y+", z "+z;
  }
}