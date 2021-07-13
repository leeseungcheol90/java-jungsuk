package com.chobo.ch06;

class Data {int x;}

public class ReferenceReturnEx {
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Data d=new Data();
    d.x=10;

    Data d2=copy(d);
    System.out.println("d.x ="+d.x);
    System.out.println("d.x ="+d2.x);
  }

  static Data copy(Data d) {
    Data tmp=new Data();
    tmp.x=d.x;

    return tmp;
  }
}
