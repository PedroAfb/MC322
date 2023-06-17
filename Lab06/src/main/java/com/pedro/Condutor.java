package com.pedro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataNasc;
    private List <Sinistro> listaSinistros;

    public Condutor(String cpf, String nome, String telefone, String email, String endereco, Date dataNasc,String dataNascimentoString ,List <Sinistro> listaSinistros){
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        if(listaSinistros != null)
            this.listaSinistros = listaSinistros;
        else
            this.listaSinistros = new ArrayList<>();

        this.nome = nome;
        if (dataNasc == null){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.dataNasc = format.parse(dataNascimentoString);
            } catch (ParseException e) {
                System.out.println("Formato de data inválido!");
                e.printStackTrace();
            }
        }
        else
            this.dataNasc = dataNasc;

        if(Validacao.validarCPF(cpf))
            this.cpf = cpf.replaceAll("[^0-9]", "");
        else
            throw new IllegalArgumentException("CPF inválido. A instância do objeto ClientePF foi cancelada.");

    }

    public String getCpf() {
        return cpf;
    }
    public Date getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void adicionaSinistro(Condutor condutor, SeguroPF seguroPF, SeguroPJ seguroPJ ,Sinistro sinistro){
        condutor.getListaSinistros().add(sinistro);
        if(seguroPF != null)
            seguroPF.getListaSinistros().add(sinistro);
        else
            seguroPJ.getListaSinistros().add(sinistro);
    }

    public static Condutor criarCondutor(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Digite o CPF do condutor:");
        String cpf = scanner.nextLine();

        System.out.println("Digite o nome do condutor:");
        String nome = scanner.nextLine();

        System.out.println("Digite o telefone do condutor:");
        String telefone = scanner.nextLine();

        System.out.println("Digite o endereço do condutor:");
        String endereco = scanner.nextLine();

        System.out.println("Digite o email do condutor:");
        String email = scanner.nextLine();
        System.out.println("Digite a data de nascimento do condutor:");
        String dataNasc = scanner.nextLine();

        // Cria e retorna a instância do Condutor com os atributos preenchidos
        return new Condutor(cpf, nome, telefone, email, endereco, null, dataNasc, null);
    }

    public static Condutor buscaCondutor(SeguroPF seguroPF, SeguroPJ seguroPJ,Scanner scanner){

        if(seguroPF != null){
            try{seguroPF.imprimirListaCondutor();
             System.out.println("Digite o cpf desse condutor:");
            String cpf = scanner.nextLine();
            cpf = cpf.replaceAll("[^0-9]", "");
            for(Condutor condutor : seguroPF.getListaCondutores()){
                if(condutor.getCpf().equals(cpf)){
                    return condutor;
                }
            }

            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
      
            }
        }
        else{
            try{seguroPJ.imprimirListaCondutor();
            System.out.println("Digite o cpf desse condutor:");
            String cpf = scanner.nextLine();
            cpf = cpf.replaceAll("[^0-9]", "");
            for(Condutor condutor : seguroPJ.getListaCondutores()){
                if(condutor.getCpf().equals(cpf)){
                    return condutor;
                }
            }

            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());                
            }
        }
        throw new IllegalArgumentException("Condutor inválido, não foi encontrado.");

    }

    public void imprimirListaSinistros() {
    if (listaSinistros.isEmpty()) {
        System.out.println("A lista de sinistros está vazia.");
    } else {
        System.out.println("Lista de Sinistros:");
        for (Sinistro sinistro : listaSinistros) {
            System.out.println(sinistro.toString());
            System.out.println("-------------------------");
        }
    }
}


    public String toString() {
        imprimirListaSinistros();
        return "Condutor {" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNasc=" + dataNasc +
                '}';
    }

}
