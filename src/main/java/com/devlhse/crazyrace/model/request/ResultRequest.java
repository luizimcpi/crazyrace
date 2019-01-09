package com.devlhse.crazyrace.model.request;

import com.devlhse.crazyrace.model.Pilot;
import com.devlhse.crazyrace.model.Result;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class ResultRequest {

    private String hour;
    private Pilot pilot;
    private int lap;
    private String lapTime;
    private double averageLapSpeed;

    public ResultRequest(String hour, Pilot pilot, int lap, String lapTime, double averageLapSpeed) {
        this.hour = hour;
        this.pilot = pilot;
        this.lap = lap;
        this.lapTime = lapTime;
        this.averageLapSpeed = averageLapSpeed;
    }

    public String getHour() {
        return hour;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public int getLap() {
        return lap;
    }

    public String getLapTime() {
        return lapTime;
    }

    public double getAverageLapSpeed() {
        return averageLapSpeed;
    }

    @Override
    public String toString() {
        return "ResultRequest{" +
                "hour='" + hour + '\'' +
                ", pilot=" + pilot +
                ", lap=" + lap +
                ", lapTime='" + lapTime + '\'' +
                ", averageLapSpeed=" + averageLapSpeed +
                '}';
    }

    public Result toResultModel(ResultRequest resultRequest){
        //TODO refactor
        DateTimeFormatter formatterWithoutHour = DateTimeFormat.forPattern("mm:ss.SSS");
        DateTimeFormatter formatterWithHour = DateTimeFormat.forPattern("HH:mm:ss.SSS");
        Result result = new Result(
                formatterWithHour.parseDateTime(resultRequest.getHour()),
                resultRequest.getPilot(),
                resultRequest.getLap(),
                formatterWithoutHour.parseDateTime(resultRequest.lapTime),
                resultRequest.getAverageLapSpeed());
//        System.out.println("RESULT MODEL >>>> " + result.toString());
        return result;
    }

}
