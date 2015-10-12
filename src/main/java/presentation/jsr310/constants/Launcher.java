package presentation.jsr310.constants;

import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class Launcher {

    public static void main(String[] args) {
        // DayOfWeek
        DayOfWeek day = DayOfWeek.MONDAY;               // the numeric value of {@code 1}.
        System.out.println(day);                        // MONDAY
        System.out.println(day.getValue());             // 1
        System.out.println(Arrays.asList(DayOfWeek.values()));
        // format
        Locale locale = Locale.getDefault();
        System.out.println(day.getDisplayName(TextStyle.FULL, locale));     // Monday
        System.out.println(day.getDisplayName(TextStyle.NARROW, locale));   // M
        System.out.println(day.getDisplayName(TextStyle.SHORT, locale));    // Mon

        // Month
        Month month = Month.JANUARY;                   // the numeric value of {@code 1}.
        System.out.println(month);
        System.out.println(Arrays.asList(Month.values()));

        // useful constants
        LocalTime lt1 = LocalTime.MIDNIGHT;         // 00:00
        System.out.println(lt1);
        LocalTime lt2 = LocalTime.NOON;             // 12:00
        System.out.println(lt2);
        LocalTime lt3 = LocalTime.MIN;              // 00:00
        System.out.println(lt3);
        LocalTime lt4 = LocalTime.MAX;              // 23:59:59.999999999
        System.out.println(lt4);
        LocalDate lt5 = LocalDate.MAX;              // +999999999-12-31
        System.out.println(lt5);
        LocalDate lt6 = LocalDate.MIN;              // -999999999-01-01
        System.out.println(lt6);
        LocalDateTime lt7 = LocalDateTime.MAX;      // +999999999-12-31T23:59:59.999999999
        System.out.println(lt7);
        LocalDateTime lt8 = LocalDateTime.MAX;      // +999999999-12-31T23:59:59.999999999
        System.out.println(lt8);
    }
}
