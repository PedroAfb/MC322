import java.util.Scanner;
import java.util.Random;

public class Sinistro {
    private final int id = GeraID();
    private String data;
    private String endereco;
    private Seguradora seguradora;    
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(int id, String data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    public int getId(){
        return id;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public Seguradora getSeguradora(){
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public int GeraID(){
        // Gera um número int aleatório para o id
        Random gerador = new Random();
        return gerador.nextInt(100);

    }

    public void implementacaoSinistro(Sinistro sinistro, Veiculo veiculo, Seguradora seguradora, Cliente cliente, Scanner scan){
        sinistro.setCliente(cliente);
        sinistro.setSeguradora(seguradora);
        sinistro.setVeiculo(veiculo);
    }
    public String toString() {
        return "Sinistro {" +
                "id=" + getId()+
                ", data='" + getData() + '\'' +
                ", endereco='" + getEndereco()+
                '}';
    }
} 

