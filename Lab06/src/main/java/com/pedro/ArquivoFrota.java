package com.pedro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoFrota {
    //ID_FROTA,PLACA_VEICULO1,PLACA_VEICULO2,PLACA_VEICULO3
    public String stringWriter(Frota frota){
        String veiculos = "";
        if (frota.getListaVeiculos() != null){
            for (Veiculo veiculo : frota.getListaVeiculos()){
                veiculos += veiculo.getPlaca() + "; ";
            }
        }
        String dados = frota.getCode() + ", " + veiculos;
        return dados;
    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("frotas.csv");
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

        try (BufferedReader reader = new BufferedReader(new FileReader("frotas.csv"))) {
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
