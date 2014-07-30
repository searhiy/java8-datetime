package org.eyalgo.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SampleZone {

    public static void main(String[] args) {
        
        LocalTime now = LocalTime.now();
        LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(String.format("now is %s and in LA is %s", now, currentTimeInLosAngeles));

        oneWayToShow();
    }
    
    private static void oneWayToShow() {
        
        ZoneId leavingZone = ZoneId.of("Asia/Tel_Aviv");
        ZoneId arrivingZone = ZoneId.of("America/New_York");
        
        LocalDateTime leaving = LocalDateTime.of(2014, Month.JULY, 16, 23, 00);
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);
        
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone).plusHours(11).plusMinutes(51);

        printTravelTimes(departure, arrival);
        
    }

    private static void printTravelTimes(ZonedDateTime departure, ZonedDateTime arrival) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-d  HH:mm");
        System.out.println(String.format("Departure: %s", departure.format(format)));
        System.out.println(String.format("Arrival: %s", arrival.format(format)));
    }
}
