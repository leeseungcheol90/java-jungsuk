package com.chobo.algorithm;

public class LinkedQueueTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LinkedQueue lq=new LinkedQueue();

    for (int i=1;i<20;i++)
      lq.in(i);

    for (int i=1;i<20;i++)
      System.out.println(lq.out()); 
  }
}

class LinkedQueue {
  Ref que=null;
  Ref tmp=null;

  void in(int value) {
    if (que==null) que=new Ref(value);
    else {
      Ref now=new Ref(value);
      if (que.next==null) {
        que.next=now;
        now.prev=que;
      } else {
        tmp.next=now;
        now.prev=tmp;
      }
      tmp=now;
    }
  }

  int out() {
    Ref tmp=que;
    que=que.next;
    return tmp.value;        
  }
}

class Ref {
  int value;
  Ref next;
  Ref prev;

  Ref(int value) {
    this.value=value;
    prev=null;
    next=null;
  }
}