package com.chobo.algorithm;

class Material {
  int value;
  Material next;

  Material(int value) {
    this.value=value;
    this.next=null;
  }
}

class Stack {
  Material material=null;
  int count=0;

  void inStack(int value) {
    if (material==null) {      
      material=new Material(value);
      ++count;
    }
    else {
      Material tmp=material;
      while(true) {
        if (tmp.next==null) {
          tmp.next=new Material(value);
          ++count;
          break;
        } else {
          tmp=tmp.next;
        }
      }
    }
  }

  int deStack() {    
    Material tmp=material;

    for (int i=count;i>1;i--) {
      tmp=tmp.next;
    }
    --count;
    return tmp.value;
  }
}

public class StackTest1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Stack q=new Stack();


    q.inStack(1);


    System.out.println(q.deStack());

  }

}