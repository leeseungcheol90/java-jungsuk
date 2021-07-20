package com.chobo.algorithm;

public class TreeSetTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}

class Treeset {
  Node node;

  void put(int value) {
    if (node==null) node=new Node(value);
    else {
      Node tmp=node;
      while (true) {
        if (value<tmp.value) {
          if (tmp.left==null) 
            tmp.left=new Node(value);
          else {
            tmp=tmp.left;
            continue;
          }
        } else if (value>tmp.value) {
          if (tmp.right==null) 
            tmp.right=new Node(value);
          else {
            tmp=tmp.right;
            continue;
          }
        }
        break;
      }
    }
  }

  boolean delete(int value) {
    Node tmp=node;
    while (true) {
      if (value==tmp.value) {
        tmp.value=-1;
        return true;
      } else if (value<tmp.value) {      
        if (tmp.left!=null)
          tmp=tmp.left;
        else break;
      } else {
        if (tmp.right!=null)
          tmp=tmp.right;
        else break;
      }
    }
    return false;
  }

}

class Node {
  Node left;
  Node right;
  int value;

  Node(int value) {
    this.value=value;
    this.right=null;
    this.left=null;
  }
}
