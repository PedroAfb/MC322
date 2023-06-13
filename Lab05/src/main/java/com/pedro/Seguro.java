package com.pedro;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
    private final int id = getId();
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List <Sinistro> listaSinistros;
    private List <Condutor> listaCondutores;
    private double valorMensal;

    public Seguro(String dataInicio, String dataFim, Seguradora seguradora, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, double valorMensal){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataFim = format.parse(dataFim);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }

        try {
            this.dataInicio = format.parse(dataInicio);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }
        
        if(listaSinistros ==null)
            this.listaSinistros = new ArrayList<>();
        else
            this.listaSinistros = listaSinistros;
        
        if(listaCondutores == null)
            this.listaCondutores = new ArrayList<>();
        else
            this.listaCondutores = listaCondutores;
            
        this.seguradora = seguradora;
        this.valorMensal = valorMensal;
    }

    public Date getDataFim() {
        return dataFim;
    }
    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public int getId() {
        return id;
    }
    public List<Condutor> getListaCondutores() {
        return listaCondutores;
    }
    public void setListaCondutores(List<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }
    public List<Sinistro> getListaSinistros() {
        return listaSinistros;
    }
    public void setListaSinistros(List<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }
    public Seguradora getSeguradora() {
        return seguradora;
    }
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }
    public double getValorMensal() {
        return valorMensal;
    }
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int GeraID(){
        // Gera um número int aleatório para o id
        Random gerador = new Random();
        return gerador.nextInt(100);

    }

    public abstract boolean autorizarCondutor(Condutor condutor);
    /*
    {
        if(condutor != null){
            if(!listaCondutores.contains(condutor)){
                listaCondutores.add(condutor);
                System.out.println("Condutor Autorizado");
                return true;
            }
            else{
                System.out.println("Conduntor já estava autorizado");
                return false;
            }
        }
        else{
            System.out.println("Condutor inválido");
            return false;
        }
    }*/

    public abstract boolean desautorizarCondutor(Condutor condutor);
    /*{
        if(condutor != null){
            if(!listaCondutores.contains(condutor)){
                System.out.println("Condutor desconhecido");
                return false;
            }
            else{
                listaCondutores.remove(condutor);
                System.out.println("Conduntor desautorizado");
                return true;
            }
        }
        else{
            System.out.println("Condutor inválido");
            return false;
        }
    }*/

    public abstract void calcularValor(Cliente cliente, Seguradora seguradora);

    public abstract void gerarSinistro(Scanner scanner, Condutor condutor);

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
    
    public void imprimirListaCondutor() {
    if (listaCondutores.isEmpty()) {
        throw new IllegalArgumentException("A lista de condutores está vazia.");
    } else {
        System.out.println("Lista de Condutores:");
        for (Condutor condutor : listaCondutores) {
            System.out.println(condutor.toString());
            System.out.println("-------------------------");
        }
    }
}

    public String toString() {
        return "Seguro {" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", valorMensal=" + valorMensal +
                '}';
    }

}
