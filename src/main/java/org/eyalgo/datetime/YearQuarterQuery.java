package org.eyalgo.datetime;

import static org.eyalgo.datetime.YearQuarter.Q1;
import static org.eyalgo.datetime.YearQuarter.Q2;
import static org.eyalgo.datetime.YearQuarter.Q3;
import static org.eyalgo.datetime.YearQuarter.Q4;

import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class YearQuarterQuery {

	public YearQuarterQuery() {
	}

	public static YearQuarter findQuarter(TemporalAccessor date) {
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		if (month >= 1 && month <= 3) {
			return Q1;
		} else if (month >= 4 && month <= 6) {
			return Q2;
		} else if (month >= 7 && month <= 9) {
			return Q3;
		} else {
			return Q4;
		}
	}
}



