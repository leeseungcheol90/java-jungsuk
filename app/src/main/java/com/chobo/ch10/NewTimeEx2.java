package com.chobo.ch10;

import java.time.*;

public class NewTimeEx2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LocalDate date=LocalDate.of(2015, 12, 31);
    LocalTime time=LocalTime.of(12,34, 56);

    LocalDateTime dt=LocalDateTime.of(date, time);

    ZoneId zid=ZoneId.of("Asia/Seoul");
    ZonedDateTime zdt=dt.atZone(zid);

    ZonedDateTime seoulTime=ZonedDateTime.now();
    ZoneId nyId=ZoneId.of("America/New_York");
    ZonedDateTime nyTime=ZonedDateTime.now().withZoneSameInstant(nyId);
    ZonedDateTime nyTime2=LocalDateTime.now().atZone(nyId);

    OffsetDateTime odt=seoulTime.toOffsetDateTime();
    OffsetDateTime odt2=nyTime.toOffsetDateTime();
    OffsetDateTime odt3=nyTime2.toOffsetDateTime();

    System.out.println(dt);
    System.out.println(zid);
    System.out.println(zdt);
    System.out.println(seoulTime);
    System.out.println(nyTime);
    System.out.println(nyTime2);
    System.out.println(odt);
    System.out.println(odt2);
    System.out.println(odt3);
  }

}
