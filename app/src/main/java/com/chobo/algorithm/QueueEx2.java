package com.chobo.algorithm;

class Data {
  int value;
  Data next;

  Data(int value) {
    this.value=value;
    this.next=null;
  }
}

class Queue {
  Data data=null;

  void inQueue(int value) {
    if (data==null) data=new Data(value);
    else {
      Data tmp=data;
      while(true) {
        if (tmp.next==null) {
          tmp.next=new Data(value);
          break;
        } else {
          tmp=tmp.next;
        }
      }
    }
  }


  int deQueue() {
    Data tmp=data;
    data=data.next;
    return tmp.value;
  }

  boolean isEmpty() {
    return (data==null) ? true : false; 
  }
}

public class QueueEx2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Queue q=new Queue();

    for (int i=1;i<=20;i++)
      q.inQueue(i);

    for (int i=1;i<=20;i++)
      System.out.println(q.deQueue());

  }

}
