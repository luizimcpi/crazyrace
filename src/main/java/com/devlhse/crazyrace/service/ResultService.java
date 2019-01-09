package com.devlhse.crazyrace.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.devlhse.crazyrace.model.Result;
import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.model.response.ResultResponse;
import com.devlhse.crazyrace.util.StringUtils;

public class ResultService {

    public static final String INVALID_INPUT_CHAR = "-";

    public ResultRequest convertLineToRequest(String[] splitedLine) {

        String hour = null;
        int pilotCode = 0;
        String pilotName = null;
        int lap = 0;
        String lapTime = null;
        double averageLapSpeed = 0;

        String word;
        for (int i = 0; i <= splitedLine.length - 1; i++) {
            word = splitedLine[i];
            if(i == 0){
                hour = word;
            }
            if(i == 1){
                pilotCode = StringUtils.convertToInt(word);
            }
            if(i == 3){
                pilotName = word;
            }
            if(i == 4){
                lap = StringUtils.convertToInt(word);
            }
            if(i == 5){
                lapTime = word;
            }
            if(i == 6){
                averageLapSpeed = StringUtils.convertToDouble(word.replace(",", "."));
            }
        }
        
        return new ResultRequest(hour, pilotCode, pilotName, lap, lapTime, averageLapSpeed );
    }

	public List<ResultResponse> getOutput(List<ResultRequest> results) {
		
		List<ResultRequest> sortedRequest = orderRequestListByPilotAndLap(results);
	    List<Result> resultsModel = 
	    		sortedRequest.stream()
	    		.map(r -> r.toResultModel(r))
	    		.collect(Collectors.toList());
		
		for (Result result : resultsModel) {
			System.out.println("RESULT >>>>> " + result.toString());
		}
		
		return new ArrayList<>();
	}

	private List<ResultRequest> orderRequestListByPilotAndLap(List<ResultRequest> results) {
		Comparator<ResultRequest> comparator = Comparator.comparing(request -> request.getPilotCode());
	    comparator = comparator.thenComparing(Comparator.comparing(request -> request.getLap()));

	    Stream<ResultRequest> requestStream = results.stream().sorted(comparator);
	    List<ResultRequest> sortedRequest = requestStream.collect(Collectors.toList());
		return sortedRequest;
	}
}
