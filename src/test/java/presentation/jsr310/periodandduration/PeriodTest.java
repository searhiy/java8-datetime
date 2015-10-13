package presentation.jsr310.periodandduration;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Serhii K. on 13.10.2015.
 */
public class PeriodTest {

    @Test
    public void test_period_between_dates(){
        LocalDate twins = LocalDate.parse("2003-11-18");
        LocalDate mayhem = LocalDate.parse("2009-06-01");
        Period timeBetween = Period.between(twins,mayhem);
        assertThat(timeBetween.getYears(),is(5));
        assertThat(timeBetween.getMonths(),is(6));
        assertThat(timeBetween.getDays(),is(14));
    }


}
