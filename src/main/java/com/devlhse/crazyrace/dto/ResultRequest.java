package com.devlhse.crazyrace.dto;

import com.devlhse.crazyrace.model.Pilot;

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
}
