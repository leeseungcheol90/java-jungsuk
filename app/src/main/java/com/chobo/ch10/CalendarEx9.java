package com.chobo.ch10;

import java.util.*;

public class CalendarEx9 {
  int[] monthDays= {31,28,31,30,31,30,31,31,30,31,30,31};
  int year;
  int month;
  int date;
  int days;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    CalendarEx9 ex9=new CalendarEx9();
    Calendar cal=Calendar.getInstance();
    cal.set(2015,6,29); 

    System.out.println(ex9.dateToDays(cal));

    Calendar str=ex9.daysToDate(735778);
    System.out.println(str.get(Calendar.YEAR)+"-"+str.get(Calendar.MONTH)
    +"-"+str.get(Calendar.DATE));
  }

  Calendar daysToDate(int days) {
    year=1;
    month=1;
    date=1;
    Calendar cal=Calendar.getInstance();

    while (days>=365) {
      days-=(isLeapYear(year)) ? 366 : 365;
      year++;
    }

    for (int i=0;days-monthDays[i]>=0;i++) {
      if (isLeapYear(year) && month==2)
        --days;
      days-=monthDays[i];
      month++;
    }

    date=days;
    cal.set(year, month,date);
    return cal;
  }

  boolean isLeapYear(int year) {
    return ((year%4==0) && (year%100!=0) || (year%400==0));
  }

  int dateToDays(Calendar cal) {
    year=cal.get(Calendar.YEAR);
    month=cal.get(Calendar.MONTH);
    date=cal.get(Calendar.DATE);
    days=0;

    System.out.println(year+"-"+month+"-"+date);

    for (int i=1;i<year;i++) 
      days+=(isLeapYear(i)) ? 366 : 365;

    if (isLeapYear(year) && month>=3) 
      days++;

    for (int i=0;i<=month-2;i++) 
      days+=monthDays[i];

    days+=date;

    return days;
  }

}
