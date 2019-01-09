package com.devlhse.crazyrace.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.joda.time.LocalTime;

import com.devlhse.crazyrace.model.Result;
import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.model.response.ResultResponse;
import com.devlhse.crazyrace.util.StringUtils;

public class ResultService {

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
	    Map<Integer, List<Result>> resultsMap = 
	    		sortedRequest.stream()
	    		.map(r -> r.toResultModel(r))
	    		.collect(Collectors.groupingBy(x -> x.getPilot().getCode()));

		List<ResultResponse> responses = createResponseList(resultsMap);

		return setPositions(orderResponseListByTotalRaceTime(responses));
	}

	private List<ResultResponse> createResponseList(Map<Integer, List<Result>> resultsMap) {

    	List<ResultResponse> responses = new ArrayList<>();

		for (Map.Entry<Integer, List<Result>> entry : resultsMap.entrySet()){
			int totalCompletedLaps = 0;
			int pilotCode = entry.getKey();
			int position = 0;
			String pilotName = "";
			String totalRaceTime = "";
			long raceTimeSum = 0;

			for(Result result : entry.getValue()) {
				totalCompletedLaps++;
				raceTimeSum += result.getLapTime().getMillisOfDay();
				pilotName = result.getPilot().getName();
			}
			LocalTime lt = new LocalTime(raceTimeSum);
			totalRaceTime = lt.toString("mm:ss.SSS");
			ResultResponse resultResponse = new ResultResponse(position, pilotCode, pilotName, totalCompletedLaps, totalRaceTime);
			responses.add(resultResponse);
		}

		return responses;
	}

	private List<ResultResponse> setPositions(List<ResultResponse> responses) {
		List<ResultResponse> formattedResponses = new ArrayList<>();
	    int position = 0;
	    for (ResultResponse resultResponse : responses) {
	    	ResultResponse responseConverted = new ResultResponse(++position, resultResponse.getPilotCode(), resultResponse.getPilotName(), resultResponse.getTotalCompletedLaps(), resultResponse.getTotalRaceTime());
	    	formattedResponses.add(responseConverted);
		}
		return formattedResponses;
	}

	private List<ResultRequest> orderRequestListByPilotAndLap(List<ResultRequest> results) {
		Comparator<ResultRequest> comparator = Comparator.comparing(request -> request.getPilotCode());
	    comparator = comparator.thenComparing(request -> request.getLap());

	    Stream<ResultRequest> requestStream = results.stream().sorted(comparator);
	    List<ResultRequest> sortedRequest = requestStream.collect(Collectors.toList());
		return sortedRequest;
	}
	
	private List<ResultResponse> orderResponseListByTotalRaceTime(List<ResultResponse> responses){
		Comparator<ResultResponse> comparator = Comparator.comparing(request -> LocalTime.parse(request.getTotalRaceTime()));
		Stream<ResultResponse> responseStream = responses.stream().sorted(comparator).filter(r -> r.getTotalCompletedLaps() > 3);
		return responseStream.collect(Collectors.toList());
	}
}
