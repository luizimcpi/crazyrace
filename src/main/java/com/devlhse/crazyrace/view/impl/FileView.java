package com.devlhse.crazyrace.view.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.devlhse.crazyrace.model.Pilot;
import com.devlhse.crazyrace.model.Result;
import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.service.ResultService;
import com.devlhse.crazyrace.util.StringUtils;
import com.devlhse.crazyrace.view.MainView;

public class FileView implements MainView {

	private final ResultService resultService;

	public FileView(ResultService resultService) {
		this.resultService = resultService;
	}

	public void init() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String fileName = input.nextLine();
		List<Result> results = new ArrayList<>();
		System.out.println("<<<<<<<<<<<<<============================Output =============================>>>>>>> ");
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader fileReader = new BufferedReader(file);
			boolean firstLine = true;
			String line = fileReader.readLine();

			while (line != null) {
				if(!firstLine) {
//					System.out.println("LINE CONTENT >>>>>> " + line);
					results.add(resultService.convertRequestLine(StringUtils.splitLineInput(line)));
				}

				line = fileReader.readLine();
				firstLine = false;
			}

			file.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();

		results.sort(Comparator.comparing(Result::getLap));

		for (Result result : results) {
			System.out.println("RESULT >>>>> " + result.toString());
		}
	}
}
