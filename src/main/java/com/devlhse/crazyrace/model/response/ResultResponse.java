package com.devlhse.crazyrace.model.response;

import com.devlhse.crazyrace.constants.StringUtilConstants;

public class ResultResponse {

    private int position;
    private int pilotCode;
    private String pilotName;
    private int totalCompletedLaps;
    private String totalRaceTime;

    public ResultResponse(int position, int pilotCode, String pilotName, int totalCompletedLaps, String totalRaceTime) {
        super();
        this.position = position;
        this.pilotCode = pilotCode;
        this.pilotName = pilotName;
        this.totalCompletedLaps = totalCompletedLaps;
        this.totalRaceTime = totalRaceTime;
    }

    public int getPosition() {
        return position;
    }

    public int getPilotCode() {
        return pilotCode;
    }

    public String getPilotName() {
        return pilotName;
    }

    public int getTotalCompletedLaps() {
        return totalCompletedLaps;
    }

    public String getTotalRaceTime() {
        return totalRaceTime;
    }

    @Override
    public String toString() {
        return position + StringUtilConstants.TAB_SPACE + pilotCode + StringUtilConstants.TAB_SPACE + pilotName + StringUtilConstants.TAB_SPACE
                + totalCompletedLaps + StringUtilConstants.TAB_SPACE + totalRaceTime;
    }

}
