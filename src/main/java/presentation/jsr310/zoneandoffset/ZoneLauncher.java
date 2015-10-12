package presentation.jsr310.zoneandoffset;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class ZoneLauncher {

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

    private static void timeUsingZoneExamples() {

        // current (local) time in Los Angeles
        LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));

        // current time in UTC time zone
        // Injecting Clock. We can do tests based on different zones
        LocalTime nowInUtc = LocalTime.now(Clock.systemUTC()); // 06:08:18.125

        // Calculation using zones

        LocalDateTime leaving = LocalDateTime.of(2014, Month.JULY, 16, 23, 00);

        ZoneId tlv = ZoneId.of("Asia/Tel_Aviv");
        ZonedDateTime departure = ZonedDateTime.of(leaving, tlv);

        ZoneId ny = ZoneId.of("America/New_York");

        ZonedDateTime arrival = departure.withZoneSameInstant(ny).plusHours(11).plusMinutes(51);

    }
}
