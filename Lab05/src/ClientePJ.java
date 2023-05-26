import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private List <Frota> listaFrota;

    //Construtor
    public ClientePJ (String nome, String endereco, String email, String telefone, String cnpj, Date dataFundacao, List <Frota> listaFrota){
        super(nome, endereco, email , telefone);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.listaFrota = listaFrota != null ? listaFrota : new ArrayList<>();

    }
    //Setters e Getters
    public String getCnpj () {
        return cnpj ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public List<Frota> getListaFrota() {
        return listaFrota;
    }
    public void setListaFrota(List<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Endereço: ").append(this.getEndereco()).append("\n");
        sb.append("Email: ").append(this.getEmail()).append("\n");
        sb.append("Telefone: ").append(this.getTelefone()).append("\n");
        sb.append("Lista de Frota: \n");
        for (Frota frota : this.getListaFrota()) {
            System.out.println(frota.toString());
        }
        sb.append("CNPJ: ").append(this.getCnpj()).append("\n");
        sb.append("Data de Fundação: ").append(this.getDataFundacao()).append("\n");
        return sb.toString();
}
}
