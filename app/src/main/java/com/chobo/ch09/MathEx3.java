package com.chobo.ch09;

import static java.lang.Math.PI;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class MathEx3 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int x1=1,y1=1;
    int x2=2,y2=2;

    double c=sqrt(pow(x2-x1,2)+pow(y2-y1,2));
    double a=c*sin(PI/4);
    double b=c*cos(PI/4);

    out.printf("a=%f%n", a);
    out.printf("b=%f%n", b);
    out.printf("c=%f%n", c);
    out.printf("angle=%f rad%n", atan2(a,b) );
    out.printf("angle=%f degree%n", atan2(a,b)*180/PI );
    //  out.printf("angle=%f degree%n", toDegrees(atan2(a,b)));
    out.printf("24*log10(2)=%f%n", 24*log10(2));
    out.printf("53*log10(2)=%f%n%n", 53*log10(2));
  }

}