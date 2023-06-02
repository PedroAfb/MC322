package com.pedro;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private List <Sinistro> listaSinistros;
    private List <Condutor> listaCondutores;
    private int valorMensal;

    public Seguro(int id, Date dataInicio, Date dataFim, Seguradora seguradora, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, int valorMensal){
        this.id = id;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        this.listaSinistros = new ArrayList<>();
        this.listaCondutores = new ArrayList<>();
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
    public int getValorMensal() {
        return valorMensal;
    }
    public void setValorMensal(int valorMensal) {
        this.valorMensal = valorMensal;
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

    public abstract double calcularValor(Cliente cliente, Seguradora seguradora);


    public String toString() {
        return "Seguro {" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", seguradora=" + seguradora +
                ", listaSinistros=" + listaSinistros +
                ", listaCondutores=" + listaCondutores +
                ", valorMensal=" + valorMensal +
                '}';
    }

}
