package com.pedro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoClientePF implements Arquivo {
//CPF_CLIENTE,NOME_CLIENTE,TELEFONE_CLIENTE,ENDERECO_CLIENTE,EMAIL_CLIENTE,SEXO,ENSINO,DATA_NASCIMENTO,PLACA_VEICULO_CLIENTE1

    public String stringWriter(ClientePF clientePF){
        String veiculos = "";
        if (clientePF.getListaVeiculos() != null){
            for (Veiculo veiculo : clientePF.getListaVeiculos()){
                veiculos += veiculo.getPlaca() + "; ";
            }
        }
        String dados = clientePF.getCpf() + ", " + clientePF.getNome() + ", " + clientePF.getTelefone() + ", " + clientePF.getEndereco() +
        clientePF.getEmail() + ", " + clientePF.getGenero() + ", " + clientePF.getEducacao() + ", " + clientePF.getDataNascimento() + ", "
        + veiculos;
        return dados;
    }

    public boolean gravarArquivo(String dados){
         try {
            File arquivo = new File("clientesPF.csv");
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

        try (BufferedReader reader = new BufferedReader(new FileReader("clientesPF.csv"))) {
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
