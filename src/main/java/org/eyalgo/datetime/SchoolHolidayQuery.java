package org.eyalgo.datetime;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class SchoolHolidayQuery implements TemporalQuery<Boolean> {

	public SchoolHolidayQuery() {
	}

	@Override
	public Boolean queryFrom(TemporalAccessor date) {
		int month = date.get(ChronoField.MONTH_OF_YEAR);
		if (month == Month.JULY.getValue() || month == Month.AUGUST.getValue()) {
			return true;
		}
		return false;
	}
}


