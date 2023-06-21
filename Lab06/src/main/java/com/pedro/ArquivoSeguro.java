package com.pedro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoSeguro {
   public String stringWriter(Seguro seguro){
        String sinistros = "";
        if (seguro.getListaSinistros() != null){
            for (Sinistro sinistro : seguro.getListaSinistros()){
                sinistros += sinistro.toString() + "\n";
            }
        }

        String condutores = "";
        if(seguro.getListaCondutores() != null){
            for(Condutor condutor : seguro.getListaCondutores()){
                condutores += condutor.toString() + "\n";
            }
        }

        String dados = seguro.getId() + ", " + seguro.getDataInicio() + ", " + seguro.getDataFim() + ", " +
        seguro.getSeguradora().getNome() + sinistros + condutores + seguro.getValorMensal();
        return dados;
    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("seguros.csv");
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

        try (BufferedReader reader = new BufferedReader(new FileReader("seguros.csv"))) {
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
