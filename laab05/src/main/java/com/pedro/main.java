package com.pedro;

import java.util.Scanner;

import javax.print.DocFlavor.SERVICE_FORMATTED;

public class main 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        Seguradora seguradora = new Seguradora("Seguradora do Pedro", "12991118381", "pedro.seguradora@gmail.com", 
        "Rua Ignácio", null,null , "92.917.008/0001-35", null, null);

        ClientePF clientePF = new ClientePF("Pedro", "Rua Jean", "M", "Ensino médio",
null, "894.739.120-48", "29/01/2004", "pedro193@gmail.com", "19990134032");
        Veiculo veiculo = new Veiculo("GZN-1319", "Toyota", "Corolla", 2018);
        clientePF.cadastrarVeiculo(veiculo);
        Condutor condutor = new Condutor("894.739.120-48", clientePF.getNome(), clientePF.getTelefone(), clientePF.getEmail(),
        clientePF.getEndereco(), clientePF.getDataNascimento(), null);
        seguradora.gerarSeguro(clientePF, scanner, veiculo, null, condutor);        
        


        ClientePF clientePF2 = new ClientePF("Roberto", "Rua Mateus", "M", "Superior", null,
     "570.169.060-19", "06/10/1993", "roberto.89@gmail,com", "19991021358");
        Veiculo veiculo2 = new Veiculo("DXT-0139", "Fiat", "Palio", 2014);
        clientePF2.cadastrarVeiculo(veiculo2);

        ClientePJ clientePJ = new ClientePJ(10, "Maria", "Rua Lauro", "maria.r@gmail.com",
        "12991102384", "54.710.601/0001-17", "14/01/2023", null);
        Frota frota = new Frota("3245", null);
        clientePJ.cadastrarFrota(frota);

        ClientePJ clientePJ2 = new ClientePJ(28, "Fabiana", "Rua Antônio", "fabiana.m@gmail.com",
        "19910829306", "92846102/9836-47", "08/06/2022", null);
    }
}
