package com.pedro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoCondutor {
    //CPF_CONDUTOR,NOME_CONDUTOR,TELEFONE,ENDERECO,EMAIL,DATA_NASCIMENTO
    public String stringWriter(Condutor condutor){

        String dados = condutor.getCpf() + ", " + condutor.getNome() + ", " + condutor.getTelefone() + ", " + condutor.getEndereco() +
        condutor.getEmail() + ", " + condutor.getDataNasc();
        return dados;

    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("condutores.csv");
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

        try (BufferedReader reader = new BufferedReader(new FileReader("condutores.csv"))) {
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
