package com.devlhse.crazyrace.view.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.devlhse.crazyrace.constants.StringUtilConstants;
import com.devlhse.crazyrace.model.request.ResultRequest;
import com.devlhse.crazyrace.model.response.ResultResponse;
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
        List<ResultRequest> results = new ArrayList<>();

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader fileReader = new BufferedReader(file);
            boolean firstLine = true;
            String line = fileReader.readLine();

            while (line != null) {
                if (!firstLine) {
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
        if (results.isEmpty()) {
            printDefaultErrorMessage();
        } else {
            List<ResultResponse> response = resultService.getOutput(results);

            if(response.isEmpty()){
                System.out.println("Não existe saída para a entrada informada");
            }else{
                System.out.println("Posição_Chegada" + StringUtilConstants.TAB_SPACE + "Código_Piloto" + StringUtilConstants.TAB_SPACE + "Nome_Piloto" + StringUtilConstants.TAB_SPACE + "Qtde_Voltas_Completadas" + StringUtilConstants.TAB_SPACE + "Tempo_Total_de_Prova");
                response.forEach(System.out::println);
            }
        }
    }

    private void printDefaultErrorMessage() {
        System.out.println("Não existe saída para a entrada informada");
    }

}
