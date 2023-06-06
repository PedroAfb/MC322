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
    public ClientePF(String nome, String endereco, String genero, String educacao, List <Veiculo> listaVeiculos, String cpf, String dataNascimento,String email, String telefone){
        super(nome, endereco, email, telefone);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataNascimento = format.parse(dataNascimento);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }
        this.genero = genero;
        this.educacao = educacao;
        if(listaVeiculos != null)
            this.listaVeiculos = listaVeiculos;
        else
            this.listaVeiculos = new ArrayList<>();
        if(Validacao.validarCPF(cpf))
            this.cpf = cpf.replaceAll("[^0-9]", "");
        else
            throw new IllegalArgumentException("CPF inválido. A instância do objeto ClientePF foi cancelada.");

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

    public static ClientePF criarClientePF(Scanner scanner) {
        System.out.println("Digite o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();
        System.out.println("Digite o e-mail do cliente:");
        String email = scanner.nextLine();
        System.out.println("Digite o gênero do cliente:");
        String genero = scanner.nextLine();
        System.out.println("Digite a educação do cliente:");
        String educacao = scanner.nextLine();
        System.out.println("Digite a data de nascimento do cliente:");
        String dataNasc = scanner.nextLine();

        // Cria e retorna a instância do ClientePF com os atributos preenchidos
        return new ClientePF(nome, endereco, genero, educacao, null, cpf, dataNasc, email, telefone);
    }
    
    public static ClientePF buscaClientePF(Seguradora seguradora, Scanner scanner){
        System.out.println("Digite o cpf desse cliente:");
        String cpf = scanner.nextLine();
        cpf = cpf.replaceAll("[^0-9]", "");
        for (ClientePF clientePF3 : seguradora.getListaClientePFs()){
            if(clientePF3.getCpf().equals(cpf)){
                return clientePF3;
            }
        }

        throw new IllegalArgumentException("ClientePF inválido, não foi encontrado.");
                        
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
