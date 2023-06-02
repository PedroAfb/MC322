package com.pedro;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;
    private String genero;
    private String educacao;
    private List <Veiculo> listaVeiculos;

    //Construtor
    public ClientePF(String nome, String endereco, String genero, String educacao, List <Veiculo> listaVeiculos, String cpf, Date dataNascimento,String email, String telefone){
        super(nome, endereco, email, telefone);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.educacao = educacao;
        this.listaVeiculos = listaVeiculos;
    }

    //Getters e setters
    public String getCpf () {
        return cpf ;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getEducacao() {
        return educacao;
    }
    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public boolean VerificadorCaracteresIguais(String str){
        //Verifica se a string tem todos os caracteres iguais
        char inicial = str.charAt(0);
        int tamanho = str.length();
        for (int i=0;i<tamanho;i++){
            if (str.charAt(i) != inicial)
                return false;
        }
        return true;
    }
    
    public int calcularDigitoVerificador1(String cpf) {
        // Calcula o primeiro digito verificador do cpf
        int total = 0;
        for (int i = 0; i < cpf.length(); i++) {
            int multiplicador = 10 - i;
            total += Character.getNumericValue(cpf.charAt(i)) * multiplicador;
        }
        int resto = total % 11;
        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
    
    public int calcularDigitoVerificador2(String cpf) {
        // Calcula o segundo digito verificador do cpf
        int total = 0;
        for (int i = 0; i < cpf.length(); i++) {
            int multiplicador = 11 - i;
            total += Character.getNumericValue(cpf.charAt(i)) * multiplicador;
        }
        int resto = total % 11;
        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
    
    public boolean validarCPF(String cpf){
        // função que verifica todas as regras para que um cpf seja válido
        boolean verificador;
        cpf = cpf.replaceAll("[^0-9]", "");
        int tamanho = cpf.length();
        verificador = VerificadorCaracteresIguais(cpf);
        if (tamanho != 11)
            return false;
        else if (verificador == true){
            return false;
        }
        int digito1 = calcularDigitoVerificador1(cpf.substring(0, 9));
        int digito2 = calcularDigitoVerificador2(cpf.substring(0, 9) + digito1);
        int digitoCpf1 = Character.getNumericValue(cpf.charAt(9));
        int digitoCpf2 = Character.getNumericValue(cpf.charAt(10));
        if ((digito1 == digitoCpf1) & (digito2 == digitoCpf2)){
            return true;
        }
        else{
            return false;
        }
    }

    public int calculaIdade(Date dataNascimento) {
        // Suponha que a data de nascimento da pessoa está armazenada na variável 'dataNascimento'
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);

        // Obtém a data atual
        Calendar hoje = Calendar.getInstance();

        // Calcula a diferença entre as duas datas
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH)) {
            idade--;
        } else if (hoje.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH)) {
            idade--;
        }

        // A variável 'idade' agora contém a idade da pessoa
        return idade;

    }
    
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if (veiculo != null){
            //Verifica se o veículo já está cadastrado
            if(!listaVeiculos.contains(veiculo)){
                //Adiciona o veículo na lista de veículos do cliente
                listaVeiculos.add(veiculo);
                System.out.println("O veículo foi cadastrada com sucesso");
                    return true;
                }
                else{
                    System.out.println("Esse veículo já está cadastrado com esse cliente");
                    return false;
                }
            }
            else{
                System.out.println("Esse veículo é inválido");
                return false;
            }
        }

    public boolean removerVeiculos(Veiculo veiculo){
        if(veiculo != null){
            //Verifica se o veículo já está cadastrado
            if(listaVeiculos.contains(veiculo)){
                //Remove o veículo da lista de veículos do cliente
                listaVeiculos.remove(veiculo);
                System.out.println("O veículo foi removido com sucesso");
                return true;
            }
            else{
                System.out.println("Esse veículo não pertence a esse cliente");
                return false;
            }
        }
        else{
            System.out.println("Esse veículo não é válido");
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Telefone: ").append(this.getTelefone()).append("\n");
        sb.append("email: ").append(this.getEmail()).append("\n");
        sb.append("Endereço: ").append(this.getEndereco()).append("\n");
        sb.append("Gênero: ").append(this.getGenero()).append("\n");
        sb.append("Educação: ").append(this.getEducacao()).append("\n");
        sb.append("Lista de Veículos: \n");
        for (Veiculo veiculo : this.getListaVeiculos()) {
            sb.append("  Modelo: ").append(veiculo.getModelo())
            .append(", Marca: ").append(veiculo.getMarca())
            .append(", Placa: ").append(veiculo.getPlaca())
            .append(", Ano de Fabricação: ").append(veiculo.getAnoFabricacao()).append("\n");
        }
        sb.append("CPF: ").append(this.getCpf()).append("\n");
        sb.append("Data de Nascimento: ").append(this.getDataNascimento()).append("\n");
        return sb.toString();
}

}
