package com.devlhse.crazyrace.view.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.devlhse.crazyrace.view.MainView;

public class FileView implements MainView {
	public void init() {
		Scanner ler = new Scanner(System.in);
		System.out.printf("Informe o nome de arquivo texto:\n");
		String nome = ler.nextLine();

		System.out.println("<<<<<<<<<<<<<============================Output =============================>>>>>>> ");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			while (linha != null) {
				
				System.out.println("LINE CONTENT >>>>>> " + linha);
				
				linha = lerArq.readLine();
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

		System.out.println();
	}
}
