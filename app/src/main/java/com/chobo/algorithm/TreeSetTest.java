package com.chobo.algorithm;

public class TreeSetTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Treeset tr=new Treeset();

    tr.put(130);
    tr.put(110);
    tr.put(125);
    tr.put(110);
    tr.put(127);
    tr.put(105);
    tr.put(115);
    tr.put(126);
    tr.put(129);
    tr.put(135);
    tr.put(133);
    tr.put(137);
    System.out.println(tr.delete(110));
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
    Node answerNode=node;
    Node parent=node;

    while (true) {
      if (value==answerNode.value) { // 일치하는 값을 찾은 경우
        if (answerNode.left==null && answerNode.right==null) { // 자식 노드가 모두 null인 경우
          if (answerNode.value<parent.value) {
            parent.left=null; // 일치하는 노드가 부모 노드의 왼쪽인 경우 부모 노드의 왼쪽을 null로 한다.
          }
          else 
            parent.right=null; // 일치하는 노드가 부모 노드의 오른쪽인 경우 부모 노드의 오른쪽을 null로 한다.
        } else if (answerNode.left!=null && answerNode.right==null) { // 일치하는 노드의 왼쪽이 널이 아니고 오른쪽이 null 인 경우 
          if (answerNode.value<parent.value) {
            parent.left=answerNode.left; 
          }
          else 
            parent.right=answerNode.left;          
        } else if (answerNode.left==null && answerNode.right!=null) { // 일치하는 노드의 오른쪽이 null이 아니고 왼쪽이 null 인 경우
          if (answerNode.value<parent.value) {
            parent.left=answerNode.right; // 부모 노드의 왼쪽값이 일치하는 경우
          }
          else 
            parent.right=answerNode.right; // 부모 노드의 오른쪽 값이 일치하는 경우
        } else { // 일치하는 노드의 자식 노드가 모두 null이 아닌 경우
          if (answerNode.value<parent.value) {
            parent.left=answerNode.left; 
            answerNode.left.right=answerNode.right;
            // parent.left=answerNode.right;
            // answerNode.right.left=answerNode.left
          }
          else {
            parent.right=answerNode.right;
            answerNode.right.left=answerNode.left;
            // parent.right=answerNode.left;
            // answerNode.left.right=answerNode.right;
          }
        }
        answerNode=null;
        return true;
      } else if (value<answerNode.value) {      
        if (answerNode.left!=null) {
          parent=answerNode;
          answerNode=answerNode.left;
        }
        else break;
      } else {
        if (answerNode.right!=null) {
          parent=answerNode;
          answerNode=answerNode.right;        
        }
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
