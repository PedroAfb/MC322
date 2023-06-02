package com.pedro;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, Frota frota, ClientePJ cliente){
        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.frota = frota;
        this.cliente = cliente;
    }

    public ClientePJ getCliente() {
        return cliente;
    }
    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }
    public Frota getFrota() {
        return frota;
    }
    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public boolean autorizarCondutor(Condutor condutor){
        if(condutor != null){
            if(getListaCondutores().contains(condutor)){
                getListaCondutores().add(condutor);
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
    }

    public boolean desautorizarCondutor(Condutor condutor){
        if(condutor != null){
            if(!getListaCondutores().contains(condutor)){
                System.out.println("Condutor desconhecido");
                return false;
            }
            else{
                getListaCondutores().remove(condutor);
                System.out.println("Conduntor desautorizado");
                return true;
            }
        }
        else{
            System.out.println("Condutor inválido");
            return false;
        }
    }

    public int calculaAnosFundacao(Date dataFundacao) {
        //Obbtém a data de fundação
        Calendar dataFun = Calendar.getInstance();
        dataFun.setTime(dataFundacao);

        // Obtém a data atual
        Calendar hoje = Calendar.getInstance();

        // Calcula a diferença entre as duas datas
        int anosPosFundacao = hoje.get(Calendar.YEAR) - dataFun.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataFun.get(Calendar.MONTH)) {
            anosPosFundacao--;
        } else if (hoje.get(Calendar.MONTH) == dataFun.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataFun.get(Calendar.DAY_OF_MONTH)) {
            anosPosFundacao--;
        }

        return anosPosFundacao;

    }

    public double calcularValor(Cliente cliente, Seguradora seguradora){
        ClientePJ clientePJ = (ClientePJ) cliente;
        int qntdVeiculos = 0;
        int qntdSinistrosCondutor = 0;
        //Achar a quantidades de veiculos do clientePJ
        for(Frota frota : clientePJ.getListaFrota()){
            qntdVeiculos += frota.getListaVeiculos().size();
        }

        //anos de fundação
        int anosPosFundacao = calculaAnosFundacao(clientePJ.getDataFundacao());
        int qntdSinistrosCliente = seguradora.getSinistrosPorCliente(clientePJ).size();

        //achar condutor e achar a qntdSinistro
        for (Condutor condutor : getListaCondutores()){
            if(condutor.getEndereco().equals(clientePJ.getEndereco())){
                qntdSinistrosCondutor += condutor.getListaSinistros().size();
            }
        }

        //Calcular o valor mensal
        double valorMensal  = ( CalcSeguro.VALOR_BASE.getValor() * (10 + (clientePJ.getQntdFunc() ) /10) * 
        (1 + 1/( qntdVeiculos +2) ) * (1 + 1/( anosPosFundacao +2) ) * (2 + qntdSinistrosCliente /10) * 
        (5 + qntdSinistrosCondutor /10));

        return valorMensal;
    }
}
