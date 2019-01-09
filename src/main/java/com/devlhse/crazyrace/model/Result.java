package com.devlhse.crazyrace.model;

import org.joda.time.DateTime;
import org.joda.time.LocalTime;

public class Result {

    private DateTime hour;
    private Pilot pilot;
    private int lap;
    private LocalTime lapTime;
    private double averageLapSpeed;
    
	public Result(DateTime hour, Pilot pilot, int lap, LocalTime lapTime, double averageLapSpeed) {
		super();
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

	public LocalTime getLapTime() {
		return lapTime;
	}

	public double getAverageLapSpeed() {
		return averageLapSpeed;
	}
	
	

	@Override
	public String toString() {
		return "Result [hour=" + hour + ", pilot=" + pilot + ", lap=" + lap + ", lapTime=" + lapTime
				+ ", averageLapSpeed=" + averageLapSpeed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageLapSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + lap;
		result = prime * result + ((lapTime == null) ? 0 : lapTime.hashCode());
		result = prime * result + ((pilot == null) ? 0 : pilot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (Double.doubleToLongBits(averageLapSpeed) != Double.doubleToLongBits(other.averageLapSpeed))
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (lap != other.lap)
			return false;
		if (lapTime == null) {
			if (other.lapTime != null)
				return false;
		} else if (!lapTime.equals(other.lapTime))
			return false;
		if (pilot == null) {
			if (other.pilot != null)
				return false;
		} else if (!pilot.equals(other.pilot))
			return false;
		return true;
	}
	
	
	
    
    
}
