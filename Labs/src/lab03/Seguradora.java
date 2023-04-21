package lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora {
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List <Sinistro> listaSinistros;
    private List <Cliente> listaClientes;

    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco, List <Sinistro> listaSinistros, List <Cliente> listaClientes ) {
        this . nome = nome ;
        this . telefone = telefone ;
        this . email = email ;
        this . endereco = endereco ;
        this.listaSinistros = listaSinistros != null ? listaSinistros : new ArrayList<>();
        this.listaClientes = listaClientes != null ? listaClientes : new ArrayList<>();
    }

    // Getters e setters
    public String getNome () {
        return nome ;
    }

    public void setNome ( String nome ) {
        this . nome = nome ;
    }

    public String getTelefone () {
        return telefone ;
    }

    public void setTelefone ( String telefone ) {
        this . telefone = telefone ;
    }

    public String getEmail () {
        return email ;
    }

    public void setEmail ( String email ) {
        this . email = email ;
    }

    public String getEndereco () {
        return endereco ;
    }

    public void setEndereco ( String endereco ) {
        this . endereco = endereco ;
    }
    public List <Cliente> getListaClientes () {
        return listaClientes ;
    }

    public void setListaCliente ( List <Cliente> listaClientes ) {
        this . listaClientes = listaClientes ;
    }
    public List <Sinistro> getListaSinistros () {
        return listaSinistros ;
    }

    public void setListaSinistros ( List <Sinistro> listaSinistros ) {
        this . listaSinistros = listaSinistros ;
    }

    public boolean geraSinistro(Cliente cliente, Veiculo veiculo, Seguradora seguradora, Scanner scanner) {
        Sinistro sinistro = new Sinistro(0, "", "", null, null, null);
        sinistro.implementacaoSinistro(sinistro, veiculo, seguradora, cliente, scanner);
        return true;
    }


    public void visualizarSinistro(String cliente) {
        for (Sinistro sinistro : listaSinistros) {
            Cliente nome = sinistro.getCliente();
            if (nome.getNome().equals(cliente)) {
                String str = sinistro.toString();
                System.out.println(str);
                break;
            }
        }
    }

    public void listarSinistro(){
        for (Sinistro sinistro: listaSinistros){
            sinistro.toString();
        }
    }
    
    public boolean cadastrarCliente(Cliente cliente) {
        // Verifica se o cliente já está cadastrado na lista
        if (listaClientes.contains(cliente)) {
            System.out.println("Cliente já cadastrado.");
            return false;
        }
        // Adiciona o novo cliente à lista
        listaClientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
        return true;
    }

    public boolean removerCliente(Cliente cliente) {
        if (listaClientes.contains(cliente)) {
            System.out.println("Cliente removido.");
            return true;
        }
        else{
            System.out.println("Cliente inexistente");
            return false;
        }
}

    public void listarClientes(String tipoCliente){
        /*Imprime as informações de todos os clientes 
                     da seguradora*/ 
            for (Cliente cliente : listaClientes) {
                System.out.println(cliente.toString());
            }
    }

    public void implementacaoSeguradora(Seguradora seguradora, Scanner scan){
	    System.out.println("Coloque o nome da seguradora:");
        seguradora.setNome(scan.nextLine());
        System.out.println("Coloque o telefone da seguradora:");
        seguradora.setTelefone(scan.nextLine());
        System.out.println("Coloque o email da seguradora:");
        seguradora.setEmail(scan.nextLine());
	    System.out.println("Coloque o endereço da seguradora:");
        seguradora.setEndereco(scan.nextLine());
    }

    public void relacionandoObjetos(Cliente cliente, Seguradora seguradora, Veiculo veiculo, Sinistro sinistro){
        cliente.getListaVeiculos().add(veiculo);
        sinistro.setCliente(cliente);
        sinistro.setSeguradora(seguradora);
        sinistro.setVeiculo(veiculo);
        seguradora.getListaSinistros().add(sinistro);

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguradora: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Lista de sinistros:\n");
        for (Sinistro sinistro : listaSinistros) {
            sb.append(sinistro).append("\n");
        }
        sb.append("Lista de clientes:\n");
        for (Cliente cliente : listaClientes) {
            sb.append(cliente).append("\n");
        }
        return sb.toString();
    }
}
