package com.chobo.ch10;

import java.util.*;

public class CalendarEx7 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    if (args.length!=2) {
      System.out.println("Usage : java CalendarEx7 2015 9");
      return;
    }
    int year=Integer.parseInt(args[0]);
    int month=Integer.parseInt(args[1]);

    Calendar sDay=Calendar.getInstance();
    Calendar eDay=Calendar.getInstance();

    sDay.set(year, month-1,1); // 입력한 달의 첫 날
    eDay.set(year, month-1,sDay.getActualMaximum(Calendar.DATE)); // 입력한 달의 마지막 날

    sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK)); // 입력한 일에서 요일을 뺀다.
    // for example, 수요일이라면 sDay는 전달의 마지막 날로부터 2일 전.

    eDay.add(Calendar.DATE, 7-eDay.get(Calendar.DAY_OF_WEEK)); // 마지막 일에서 (7-요일)을 더한다. 
    // for example 마지막 날이 목요일이라면, 다음 달의 3일.

    System.out.println("      "+year+"년 "+month+"월");
    System.out.println(" SU MO TU WE TH FR SA");

    for (int n=1;sDay.before(eDay) || sDay.equals(eDay);sDay.add(Calendar.DATE, 1)) {
      int day=sDay.get(Calendar.DATE);
      System.out.print((day<10) ? "  "+day : " "+day);
      if (n++%7==0) System.out.println();
    }

  }
}
