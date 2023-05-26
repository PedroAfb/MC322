
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seguradora {
    private final String cnpj;
    private String nome ;
    private String telefone ;
    private String email ;
    private String endereco ;
    private List <Seguro> listaSeguros;
    private List <ClientePF>  listaClientePFs;
    private List <ClientePJ> listaClientePJs;

    // Construtor
    public Seguradora ( String nome , String telefone , String email , String endereco, List <ClientePF> listaClientePFs, List <ClientePJ> listaClientePJs, String cnpj, List <Seguro> listaSeguros ) {
        this . nome = nome ;
        this . telefone = telefone ;
        this . email = email ;
        this . endereco = endereco ;
        this.cnpj = cnpj;
        this.listaSeguros = listaSeguros != null ? listaSeguros : new ArrayList<>();
        this.listaClientePFs = listaClientePFs != null ? listaClientePFs : new ArrayList<>();
        this.listaClientePJs = listaClientePJs != null ? listaClientePJs : new ArrayList<>();


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
    public List <Seguro> getListaSeguros () {
        return listaSeguros ;
    }

    public void setListaSeguros ( List <Seguro> listaSeguros ) {
        this . listaSeguros = listaSeguros ;
    }
    public List<ClientePF> getListaClientePFs() {
        return listaClientePFs;
    }
    public void setListaClientePFs(List<ClientePF> listaClientePFs) {
        this.listaClientePFs = listaClientePFs;
    }
    public List<ClientePJ> getListaClientePJs() {
        return listaClientePJs;
    }
    public void setListaClientePJs(List<ClientePJ> listaClientePJs) {
        this.listaClientePJs = listaClientePJs;
    }
    public String getCnpj() {
        return cnpj;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguradora: ").append(nome).append("\n");
        sb.append("Telefone: ").append(telefone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Lista de seguros:\n");
        for (Seguro seguro : listaSeguros) {
            sb.append(seguro).append("\n");
        }
        sb.append("Lista de clientes físicos:\n");
        for (ClientePF clientePf : listaClientePFs) {
            sb.append(clientePf).append("\n");
        }
        sb.append("Lista de clientes jurídicos:\n");
        for (ClientePJ clientePj : listaClientePJs) {
            sb.append(clientePj).append("\n");
        }
        return sb.toString();
    }
}
