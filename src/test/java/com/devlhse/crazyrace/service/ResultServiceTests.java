package com.devlhse.crazyrace.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.devlhse.crazyrace.model.request.ResultRequest;

public class ResultServiceTests {

	String[] VALID_INPUT = {"23:49:08.277", "038", "–", "F.MASSA", "1", "1:02.852", "44,275"};
	ResultService resultService = new ResultService();
	
	
	@Test
	public void shouldConvertSplittedLineInRequestWhenReceivesValidInput() {
		ResultRequest EXPECTED_RESULT_REQUEST = ResultRequest.builder()
				.withHour("23:49:08.277")
				.withPilotCode(38)
				.withPilotName("F.MASSA")
				.withLap(1)
				.withLapTime("1:02.852")
				.withAverageLapSpeed(44.275).build();
				
		assertEquals(EXPECTED_RESULT_REQUEST, resultService.convertLineToRequest(VALID_INPUT));
	}
			
}
