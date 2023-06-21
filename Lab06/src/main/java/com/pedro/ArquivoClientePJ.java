package com.pedro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoClientePJ implements Arquivo{
    //CNPJ_CLIENTE,NOME_CLIENTE,TELEFONE,ENDERECO,EMAIL_CLIENTE,DATA_FUND,CODE_FROTA

     public String stringWriter(ClientePJ clientePJ){
        String frotas = "";
        if (clientePJ.getListaFrota() != null){
            for (Frota frota : clientePJ.getListaFrota()){
                frotas += frota.getCode() + "; ";
            }
        }
        String dados = clientePJ.getCnpj() + ", " + clientePJ.getNome() + ", " + clientePJ.getTelefone() + ", " + clientePJ.getEndereco() +
        clientePJ.getEmail() + ", " + clientePJ.getDataFundacao() + ", "
        + frotas;
        return dados;
    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("clientesPJ.csv");
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

        try (BufferedReader reader = new BufferedReader(new FileReader("clientesPJ.csv"))) {
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
