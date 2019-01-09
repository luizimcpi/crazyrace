package com.devlhse.crazyrace.model;

import org.joda.time.DateTime;

import java.util.Objects;

public class Result {

    private DateTime hour;
    private Pilot pilot;
    private int lap;
    private DateTime lapTime;
    private double averageLapSpeed;

    public Result(DateTime hour, Pilot pilot, int lap, DateTime lapTime, double averageLapSpeed) {
        this.hour = hour;
        this.pilot = pilot;
        this.lap = lap;
        this.lapTime = lapTime;
        this.averageLapSpeed = averageLapSpeed;
    }

    public DateTime getHour() {
        return hour;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public int getLap() {
        return lap;
    }

    public DateTime getLapTime() {
        return lapTime;
    }

    public double getAverageLapSpeed() {
        return averageLapSpeed;
    }

    @Override
    public String toString() {
        return "Result{" +
                "hour=" + hour +
                ", pilot=" + pilot +
                ", lap=" + lap +
                ", lapTime=" + lapTime +
                ", averageLapSpeed=" + averageLapSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return lap == result.lap &&
                Double.compare(result.averageLapSpeed, averageLapSpeed) == 0 &&
                Objects.equals(hour, result.hour) &&
                Objects.equals(pilot, result.pilot) &&
                Objects.equals(lapTime, result.lapTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, pilot, lap, lapTime, averageLapSpeed);
    }
}
