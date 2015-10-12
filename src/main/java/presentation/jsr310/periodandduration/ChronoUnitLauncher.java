package presentation.jsr310.periodandduration;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * Created by Serhii K. on 12.10.2015.
 */
public class ChronoUnitLauncher {

    public static void main(String[] args) {

        // units
        Instant.now().plus(1, ChronoUnit.DAYS);        // Unit that represents the concept of a day.
        System.out.println(ChronoUnit.DAYS);
        System.out.println(Arrays.asList(ChronoUnit.values()));

    }
}
