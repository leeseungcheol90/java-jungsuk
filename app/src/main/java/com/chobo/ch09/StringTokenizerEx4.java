package com.chobo.ch09;

import java.util.*;

public class StringTokenizerEx4 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String input="구천칠백삼십팔조육천사백오십사억이천칠백구십만사천칠백십사";
    System.out.println(input);
    System.out.println(hangulToNum(input));
  }

  static long hangulToNum(String input) {
    String unit="십백천만억조";
    String smallUnit="영일이삼사오육칠팔구";

    long tmp=0; // 단위 앞에 붙는 값을 저장하는 변수
    long tmpResult=0; // 큰 단위(만억조)로 잘라서 값을 저장하는 변수
    long result=0; // 최종적으로 값을 저장하는 변수
    long[] num= {0,1,2,3,4,5,6,7,8,9};
    long[] unitNum= {10,100,1000,10000,(long)1e8,(long)1e12};

    StringTokenizer st=new StringTokenizer(input,unit,true);

    while(st.hasMoreTokens()) {
      String s=st.nextToken();

      if (smallUnit.indexOf(s)!=-1) { // 단위값이 아닌 경우
        tmp=num[smallUnit.indexOf(s)];
      } else { // 단위값인 경우
        if ("만억조".indexOf(s)!=-1) {
          tmpResult=(tmpResult+tmp)*unitNum["만억조".indexOf(s)+3];
          result+=tmpResult;
          tmpResult=0;
        } else {
          tmpResult+=(tmp!=0 ? tmp : 1)*unitNum[unit.indexOf(s)];          
        }
        tmp=0;
      }
    }
    return result+tmpResult+tmp;
  }
}
