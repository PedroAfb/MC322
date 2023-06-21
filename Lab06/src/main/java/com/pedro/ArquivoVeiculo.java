package com.pedro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//PLACA,MARCA,MODELO,ANO_FAB
public class ArquivoVeiculo implements Arquivo {
     public String stringWriter(Veiculo veiculo){

        String dados = veiculo.getPlaca() + ", " + veiculo.getMarca() + ", " + veiculo.getModelo() + ", " + veiculo.getAnoFabricacao();
        return dados;
    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("veiculos.csv");
            FileWriter fileWriter = new FileWriter(arquivo);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // Grava os dados no arquivo
            writer.write(dados);

            // Fecha o BufferedWriter e FileWriter
            writer.close();
            fileWriter.close();

            return true; // Gravação bem-sucedida
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Falha na gravação
        }
    }

    public String lerArquivo(){
        StringBuilder conteudo = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("veiculos.csv"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conteudo.toString();
    }
}
