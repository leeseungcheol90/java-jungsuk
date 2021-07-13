package com.chobo.ch05;

import java.util.Scanner;

public class myokgopsu {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int sum=1;
    int myok=1;
    Scanner sc=new Scanner(System.in);

    System.out.println("숫자를 입력하세요.>>");
    myok=Integer.parseInt(sc.nextLine());

    for (int i=1;i<=myok;i++) {
      sum*=myok;
    }

    System.out.println(sum);
  }

}
