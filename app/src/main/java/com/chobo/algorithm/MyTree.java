package com.chobo.algorithm;

import java.util.HashSet;
import com.chobo.algorithm.MyTree.Node;

public class MyTree {
  public static void main(String[] args) {

    MyTree mytree = new MyTree(500);
    HashSet<Integer> randomSet = new HashSet<Integer>();

    while(randomSet.size() != 1000) {
      randomSet.add((int)(Math.random() * 1000) + 1);
    }

    // 1000개값 인서트
    for(int item : randomSet) {
      mytree.insert(item);
    }

    // 1000개값 찾아보기
    for(int item : randomSet) {
      if(!mytree.search(item)) {
        System.out.println("이거뜨면 잘못짠거");
      }
    }

    // 10개값만 삭제해보기..
    for(int i = 0; i < 10; i++) {
      if(!mytree.delete((int)(Math.random() * 1000) + 1)) {
        System.out.println("이거뜨면 잘못짠거");
      }
    }

  }


  Node head;

  MyTree(int value) {
    this.head = new Node(value);
  }

  // 트리에 값 집어넣기
  public void insert(int value) {
    Node currentNode = this.head;
    while(true) {
      if(value < currentNode.value) {
        if(currentNode.left != null) {
          currentNode = currentNode.left;
        } else {
          currentNode.left = new Node(value);
          break;
        }
      } else {
        if(currentNode.right != null) {
          currentNode = currentNode.right;
        } else {
          currentNode.right = new Node(value);
          break;
        }
      }
    }
  }

  // 값이 있는지 확인
  public boolean search(int value) {
    Node currentNode = this.head;
    while(currentNode != null) {
      if(currentNode.value == value) {
        return true;
      } else if(value < currentNode.value) {
        currentNode = currentNode.left;
      } else {
        currentNode = currentNode.right;
      }
    }
    return false;
  }

  // 삭제할 Node의 오른쪽 자식 선택
  // 오른쪽 자식의 가장 왼쪽에 있는 Node를 선택
  // 해당 Node를 삭제할 Node의 Parent Node의 왼쪽 Branch가 가리키게함
  // 해당 Node의 왼쪽 Branch가 삭제할 Node의 왼쪽 Child Node를 가리키게 함
  // 해당 Node의 오른쪽 Branch가 삭제할 Node의 오른쪽 Child Node를 가리키게 함
  // 만약 해당 Node가 오른쪽 Child Node를 가지고 있었을 경우에는, 해당 Node의 본래 Parent node의 왼쪽 Branch가 해당 오른쪽 Child Node를 가리키게함
  // 케이스별로 분할정복을 해서 문제를 해결한다
  public boolean delete(int value) {
    boolean searched = false;
    Node currentNode = this.head;
    //삭제할 노드의 부모노드를 알고있어야함
    Node parent = this.head;

    while(currentNode != null) {
      if(currentNode.value == value) {
        searched = true;
        break;
      } else if(value < currentNode.value) {
        parent = currentNode;
        currentNode = currentNode.left;
      } else {
        parent = currentNode;
        currentNode = currentNode.right;
      }
    }

    if(searched == false) {
      return false;
    }


    // 케이스1 삭제할 노드가 리프노드일경우
    if(currentNode.left == null && currentNode.right == null) {
      if(value < parent.value) {
        parent.left = null;
      } else {
        parent.right = null;
      }
      return true;
    }

    // 케이스2 삭제할 노드의 자식이 왼쪽 자식 한개를 가지고  있을 경우
    if(currentNode.left != null && currentNode.right == null) {
      if(value < parent.value) {
        parent.left = currentNode.left;
      } else {
        parent.right = currentNode.left;
      }
      return true;
    }

    // 케이스3 삭제할 노드의 자식이 오른쪽 자식 한개를 가지고  있을 경우
    if(currentNode.left == null && currentNode.right != null) {
      if(value < parent.value) {
        parent.left = currentNode.right;
      } else {
        parent.right = currentNode.right;
      }
      return true;
    }

    // 케이스4 삭제할 노드의 자식이 왼쪽 오른쪽 모두 있을경우
    //전략 2가지
    // 왼쪽 자식의 가장큰값을 가지고 오는가
    // 오른쪽 자식의 가장 작은값을 가지고 오는가
    if(currentNode.left != null && currentNode.right != null) {
      if(value < parent.value) {
        Node changeNode = currentNode.right;
        Node changeNodePareant = currentNode.right;
        while(changeNode.left != null) {
          changeNodePareant = changeNode;
          changeNode = changeNode.left;
        }
        if(changeNode.right != null) {
          changeNodePareant.left = changeNode.right;
        } else {
          changeNodePareant.left = null;
        }
        parent.left = changeNode;
        changeNode.left = currentNode.left;
        changeNode.right = currentNode.right;

      } else {
        Node changeNode = currentNode.right;
        Node changeNodePareant = currentNode.right;
        while(changeNode.left != null) {
          changeNodePareant = changeNode;
          changeNode = changeNode.left;
        }
        if(changeNode.right != null) {
          changeNodePareant.left = changeNode.right;
        } else {
          changeNodePareant.left = null;
        }
        parent.right = changeNode;
        changeNode.left = currentNode.left;
        changeNode.right = currentNode.right;
      }

      return true;

    }

    return false;

  }

  static class Node {
    int value;
    Node left = null;
    Node right = null;

    Node(int value) {
      this.value = value;
    }

  }


}
