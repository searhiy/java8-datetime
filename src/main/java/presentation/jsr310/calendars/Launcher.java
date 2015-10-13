package presentation.jsr310.calendars;

import java.time.LocalDate;
import java.time.Year;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        Year year1 = Year.now();
        Year year2 = Year.of(2012);
        System.out.println(IsoChronology.INSTANCE.isLeapYear(year1.getValue()));
        System.out.println(IsoChronology.INSTANCE.isLeapYear(year2.getValue()));


        TemporalQuery<Chronology> chronology = TemporalQueries.chronology();
        System.out.println(LocalDate.now().query(chronology));   // ISO
        System.out.println();
    }
}
