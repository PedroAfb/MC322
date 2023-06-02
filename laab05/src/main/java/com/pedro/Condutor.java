package com.pedro;
    import java.util.Date;
import java.util.List;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private Date dataNasc;
    private List <Sinistro> listaSinistros;

    public Condutor(String cpf, String nome, String telefone, String email, String endereco, Date dataNasc, List <Sinistro> listaSinistros){
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.email = email;
        this.endereco = endereco;
        this.listaSinistros = listaSinistros;
        this.nome = nome;
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

    public String toString() {
        return "Condutor {" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNasc=" + dataNasc +
                ", listaSinistros=" + listaSinistros +
                '}';
    }

}
