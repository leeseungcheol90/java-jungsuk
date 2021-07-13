package com.chobo.algorithm;

public class StackTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Stack st=new Stack();

    for (int i=1;i<=10;i++)
      st.push(i);

    for (int i=1;i<=10;i++)
      System.out.println(st.pop());
  }

}

class Data {
  int value;
  Data next;

  Data(int value) {
    this.value=value;
    this.next=null;
  }
}

class Stack {
  Data data=null;

  void push(int value) {
    if (data==null) data=new Data(value);
    else {
      Data tmp=new Data(value);
      tmp.next=data;
      data=tmp;
    }
  }

  int pop() {
    Data tmp=data;
    data=data.next;

    return tmp.value;
  }

}
