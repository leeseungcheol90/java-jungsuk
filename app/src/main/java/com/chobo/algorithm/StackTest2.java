package com.chobo.algorithm;

class Stack2 {
  Refer refer=null;

  void push(int value) {
    if (refer==null )refer=new Refer(value);
    else {
      Refer referTmp=new Refer(value);
      referTmp.next=this.refer;
      this.refer=referTmp;
    }

  }

  int pop() {
    Refer tmp=refer;
    refer=refer.next;
    return tmp.value;
  }
}

class Refer {
  int value;
  Refer next;

  Refer(int value) {
    this.value=value;
    this.next=null;
  }
}


public class StackTest2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Stack2 q=new Stack2();

    for (int i=1;i<=30;i++)
      q.push(i);

    for (int i=1;i<=20;i++)
      System.out.println(q.pop());
  }

}
