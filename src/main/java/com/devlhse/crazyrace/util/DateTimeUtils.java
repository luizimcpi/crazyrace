package com.devlhse.crazyrace.util;

import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static LocalTime toLocalTime(String time, boolean withHour){

        if(withHour){
          return toLocalTimeWithHour(time);
        }
        return toLocalTimeWithoutHour(time);
    }

    private static LocalTime toLocalTimeWithHour(String time){
        DateTimeFormatter formatterWithHour = DateTimeFormat.forPattern("HH:mm:ss.SSS");
        try {
            return formatterWithHour.parseLocalTime(time);
        }catch(Exception e){
            return formatterWithHour.parseLocalTime("00:00:00.000");
        }
    }

    private static LocalTime toLocalTimeWithoutHour(String time){
        DateTimeFormatter formatterWithoutHour = DateTimeFormat.forPattern("mm:ss.SSS");
        try {
            return formatterWithoutHour.parseLocalTime(time);
        }catch(Exception e){
            return formatterWithoutHour.parseLocalTime("00:00.000");
        }
    }
}
