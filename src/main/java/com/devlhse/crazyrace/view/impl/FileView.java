package com.devlhse.crazyrace.view.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.devlhse.crazyrace.util.StringUtils;
import com.devlhse.crazyrace.view.MainView;

public class FileView implements MainView {
	public void init() {
		Scanner input = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String fileName = input.nextLine();

		System.out.println("<<<<<<<<<<<<<============================Output =============================>>>>>>> ");
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader fileReader = new BufferedReader(file);
			boolean firstLine = true;
			String linha = fileReader.readLine();
			while (linha != null) {

				if(!firstLine) {
					System.out.println("LINE CONTENT >>>>>> " + linha);
					String[] splitedLine = StringUtils.splitLineInput(linha);


					System.out.println("SPLITED>>>> " + splitedLine.length);
					for (String word : splitedLine) {
						System.out.println("WORD>>>>>>> " + word);
					}
				}

				linha = fileReader.readLine();
				firstLine = false;
			}

			file.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}
}
