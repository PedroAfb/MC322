package lab02;

import java.util.Random;

public class Sinistro {
    private int id;
    private String data;
    private String endereco;

    public Sinistro(int id, String data, String endereco){
        this.id = id;
        this.data = data;
        this.endereco = endereco;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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

    public int GeraID(int id){
        // Gera um número int aleatório para o id
        Random gerador = new Random();
        id = gerador.nextInt(3);
        return id;
    }
}

