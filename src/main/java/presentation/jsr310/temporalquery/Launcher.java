package presentation.jsr310.temporalquery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

/**
 * Created by Serhii K. on 07.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        queries();
        space();
        queriesInfo();
        space();
    }

    private static void queriesInfo() {

        // Smallest unit
        TemporalQuery<TemporalUnit> precision = TemporalQueries.precision();
        LocalDate.now().query(precision); // Days
        LocalTime.now().query(precision); // Nanos
        YearMonth.now().query(precision); // Months

        // Custom query - check is month in school holiday
        SchoolHolidayQuery schoolHolidayQuery = new SchoolHolidayQuery();

        YearMonth yearMonth = YearMonth.of(2014, Month.JUNE);
        Boolean isSchoolHoliday = yearMonth.query(schoolHolidayQuery); // false

        YearMonth.of(2014, Month.JULY).query(schoolHolidayQuery); // true
        YearMonth.of(2014, 8).query(schoolHolidayQuery); // true

        // Custom Query - Returns a yearly quarter (custom enum)
        YearQuarter quarter2 = YearMonth.of(2014, 6).query(YearQuarterQuery::findQuarter); // Q2
        YearQuarter quarter4 = YearMonth.of(2011, Month.DECEMBER).query(YearQuarterQuery::findQuarter); // Q4

    }

    private static void queries() {
        System.out.println("queries");
        TemporalQuery<TemporalUnit> precision = TemporalQueries.precision();
        System.out.println(LocalDate.now().query(precision)); // Days
        System.out.println(LocalTime.now().query(precision)); // Nanos
        System.out.println(YearMonth.now().query(precision)); // Months

        YearMonth yearMonth = YearMonth.of(2014, 6);
        System.out.println(yearMonth.query(new SchoolHolidayQuery())); // false
        System.out.println(YearMonth.of(2014, Month.JULY).query(new SchoolHolidayQuery())); // true
        System.out.println(YearMonth.of(2014, 8).query(new SchoolHolidayQuery())); // true
        System.out.println();
        System.out.println(YearMonth.of(2014, 6).query(YearQuarterQuery::findQuarter)); // Q2
        System.out.println(YearMonth.of(2011, Month.DECEMBER).query(YearQuarterQuery::findQuarter)); // Q4
    }

    private static void space() {

        System.out.println();
        System.out.println();
    }
}
