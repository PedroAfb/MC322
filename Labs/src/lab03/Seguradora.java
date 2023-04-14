package lab03;

import java.util.ArrayList;
import java.util.List;

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
        listaSinistros = new ArrayList<>();
        listaClientes = new ArrayList<>();
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
    
    public void adicionarSinistro(Sinistro sinistro) {
        listaSinistros.add(sinistro);
    }
    
    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    
    @Override
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
