package com.devlhse.crazyrace.view.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.model.response.ResultResponse;
import com.devlhse.crazyrace.service.ResultService;
import com.devlhse.crazyrace.util.StringUtils;
import com.devlhse.crazyrace.view.MainView;

public class FileView implements MainView {

	private static final String BLANK_SPACE = "                 ";
	private final ResultService resultService;

	public FileView(ResultService resultService) {
		this.resultService = resultService;
	}

	public void init() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String fileName = input.nextLine();
		List<ResultRequest> results = new ArrayList<>();

		try {
			FileReader file = new FileReader(fileName);
			BufferedReader fileReader = new BufferedReader(file);
			boolean firstLine = true;
			String line = fileReader.readLine();

			while (line != null) {	
				if(!firstLine) {
					results.add(resultService.convertLineToRequest(StringUtils.splitLineInput(line)));
				}

				line = fileReader.readLine();
				firstLine = false;
			}

			file.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		this.showOutput(results);
		input.close();
	}

	private void showOutput(List<ResultRequest> results) {
		if(results.isEmpty()) {
			System.out.println("Não existe saída para a entrada informada");
		} else {
			List<ResultResponse> response = resultService.getOutput(results);
			
			System.out.println("Posição Chegada   Código Piloto  Nome Piloto  Qtde Voltas Completadas  Tempo Total de Prova");
			for (ResultResponse resultResponse : response) {
				System.out.println(resultResponse.getPosition()+BLANK_SPACE+resultResponse.getPilotCode()+BLANK_SPACE+resultResponse.getPilotName()+BLANK_SPACE+resultResponse.getTotalCompletedLaps()+BLANK_SPACE+resultResponse.getTotalRaceTime());
			}
		}
		
	}

}
