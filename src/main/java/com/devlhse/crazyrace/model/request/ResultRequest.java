package com.devlhse.crazyrace.model.request;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.devlhse.crazyrace.model.Pilot;
import com.devlhse.crazyrace.model.Result;

public class ResultRequest {

    private String hour;
    private int pilotCode;
    private String pilotName;
    private int lap;
    private String lapTime;
    private double averageLapSpeed;

	private ResultRequest(Builder builder) {
		this.hour = builder.hour;
		this.pilotCode = builder.pilotCode;
		this.pilotName = builder.pilotName;
		this.lap = builder.lap;
		this.lapTime = builder.lapTime;
		this.averageLapSpeed = builder.averageLapSpeed;
	}

    public ResultRequest(String hour, int pilotCode, String pilotName, int lap, String lapTime,
			double averageLapSpeed) {
		super();
		this.hour = hour;
		this.pilotCode = pilotCode;
		this.pilotName = pilotName;
		this.lap = lap;
		this.lapTime = lapTime;
		this.averageLapSpeed = averageLapSpeed;
	}

	public String getHour() {
		return hour;
	}

	public int getPilotCode() {
		return pilotCode;
	}

	public String getPilotName() {
		return pilotName;
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
		return "ResultRequest [hour=" + hour + ", pilotCode=" + pilotCode + ", pilotName=" + pilotName + ", lap=" + lap
				+ ", lapTime=" + lapTime + ", averageLapSpeed=" + averageLapSpeed + "]";
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
		result = prime * result + pilotCode;
		result = prime * result + ((pilotName == null) ? 0 : pilotName.hashCode());
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
		ResultRequest other = (ResultRequest) obj;
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
		if (pilotCode != other.pilotCode)
			return false;
		if (pilotName == null) {
			if (other.pilotName != null)
				return false;
		} else if (!pilotName.equals(other.pilotName))
			return false;
		return true;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String hour;
		private int pilotCode;
		private String pilotName;
		private int lap;
		private String lapTime;
		private double averageLapSpeed;

		private Builder() {
		}

		public Builder withHour(String hour) {
			this.hour = hour;
			return this;
		}

		public Builder withPilotCode(int pilotCode) {
			this.pilotCode = pilotCode;
			return this;
		}

		public Builder withPilotName(String pilotName) {
			this.pilotName = pilotName;
			return this;
		}

		public Builder withLap(int lap) {
			this.lap = lap;
			return this;
		}

		public Builder withLapTime(String lapTime) {
			this.lapTime = lapTime;
			return this;
		}

		public Builder withAverageLapSpeed(double averageLapSpeed) {
			this.averageLapSpeed = averageLapSpeed;
			return this;
		}

		public ResultRequest build() {
			return new ResultRequest(this);
		}
	}
	

	public Result toResultModel(ResultRequest resultRequest){
        DateTimeFormatter formatterWithoutHour = DateTimeFormat.forPattern("mm:ss.SSS");
        DateTimeFormatter formatterWithHour = DateTimeFormat.forPattern("HH:mm:ss.SSS");
        Pilot pilot = new Pilot(resultRequest.getPilotCode(), resultRequest.getPilotName());
        Result result = new Result(
                formatterWithHour.parseDateTime(resultRequest.getHour()),
                pilot,
                resultRequest.getLap(),
                formatterWithoutHour.parseLocalTime(resultRequest.getLapTime()),
                resultRequest.getAverageLapSpeed());
        return result;
    }
	

}
