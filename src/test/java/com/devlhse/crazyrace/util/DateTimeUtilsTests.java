package com.devlhse.crazyrace.util;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTimeUtilsTests {

    @Test
    public void shouldConvertValidInputWithHourIntoLocalTime(){
        String VALID_LOCAL_TIME_WITH_HOUR = "23:49:08.277";
        LocalTime EXPECTED_RESULT = new LocalTime(VALID_LOCAL_TIME_WITH_HOUR);
        assertEquals(EXPECTED_RESULT, DateTimeUtils.toLocalTime(VALID_LOCAL_TIME_WITH_HOUR, true));
    }

    @Test
    public void shouldReturnZeroTimeWhenInvalidInputPassedToLocalTimeConversion(){
        String INVALID_LOCAL_TIME_WITH_HOUR = "invalid_input";
        LocalTime EXPECTED_RESULT = new LocalTime("00:00:00.000");
        assertEquals(EXPECTED_RESULT, DateTimeUtils.toLocalTime(INVALID_LOCAL_TIME_WITH_HOUR, true));
    }

    @Test
    public void shouldConvertValidInputWithoutHourIntoLocalTime(){
        DateTimeFormatter formatterWithoutHour = DateTimeFormat.forPattern("mm:ss.SSS");
        String VALID_LOCAL_TIME_WITHOUT_HOUR = "1:02.852";
        LocalTime EXPECTED_RESULT = formatterWithoutHour.parseLocalTime(VALID_LOCAL_TIME_WITHOUT_HOUR);
        assertEquals(EXPECTED_RESULT, DateTimeUtils.toLocalTime(VALID_LOCAL_TIME_WITHOUT_HOUR, false));
    }
}
