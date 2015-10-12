package presentation.jsr310.temporaladjuster;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        adjusters();
        space();
        int year = 2017;
        thanksgiving(year);
        space();
        customAdjuster();
    }

    private static void adjusters() {
        System.out.println("adjusters");

        LocalDate date = LocalDate.of(2014, Month.JULY, 16);

        LocalDate firstDayOfJuly = date.with(TemporalAdjusters.firstDayOfMonth()); // 2014-07-01
        System.out.println(firstDayOfJuly);

        LocalDate dateOfFirstMonday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2014-07-07
        System.out.println(dateOfFirstMonday);

    }

    private static void thanksgiving(int year) {
        LocalDate thanksGiving = Year.of(year).atMonth(Month.NOVEMBER).atDay(1)
                .with(TemporalAdjusters.lastInMonth(DayOfWeek.WEDNESDAY));
        System.out.println(thanksGiving);
    }

    private static void space() {

        System.out.println();
        System.out.println();
    }

    private static void customAdjuster(){
        LocalDate july_2014 = LocalDate.of(2014, 7, 20);
        LocalDate nextPayday = july_2014.with(new FirstTuesdayAdjuster());
        System.out.println(nextPayday);
        LocalDate august_2009 = LocalDate.of(2009, 8, 20);
        nextPayday = august_2009.with(new FirstTuesdayAdjuster());
        System.out.println(nextPayday);
    }
}
