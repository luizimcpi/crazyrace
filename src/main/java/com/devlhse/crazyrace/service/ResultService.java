package com.devlhse.crazyrace.service;

import com.devlhse.crazyrace.model.Result;
import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.model.Pilot;

public class ResultService {

    public static final String INVALID_INPUT_CHAR = "-";

    public Result convertRequestLine(String[] splitedLine) {

        String hour = null;
        int pilotCode = 0;
        String pilotName = null;
        int lap = 0;
        String lapTime = null;
        double averageLapSpeed = 0;

        ResultRequest resultRequest;

        String word;
        for (int i = 0; i <= splitedLine.length - 1; i++) {
            word = splitedLine[i];
            if(i == 0){
                hour = word;
            }
            if(i == 1){
                pilotCode = Integer.valueOf(word);
            }
            if(i == 3){
                pilotName = word;
            }
            if(i == 4){
                lap = Integer.valueOf(word);
            }
            if(i == 5){
                lapTime = word;
            }
            if(i == 6){
                averageLapSpeed = Double.valueOf(word.replace(",", "."));
            }
        }
        Pilot pilot = new Pilot(pilotCode, pilotName);
        resultRequest = new ResultRequest(hour, pilot, lap, lapTime, averageLapSpeed );
//        System.out.println("RESULT REQUEST >>>> " + resultRequest.toString());

        return resultRequest.toResultModel(resultRequest);
    }
}
