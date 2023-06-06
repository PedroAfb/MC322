package com.pedro;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(String dataInicio, String dataFim, Seguradora seguradora, double valorMensal, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, Frota frota, ClientePJ cliente){
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
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

    public void calcularValor(Cliente cliente, Seguradora seguradora){
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

        setValorMensal(valorMensal);
    }

    public void gerarSinistro(Scanner scanner, Condutor condutor) {
        System.out.println("Coloque a data do acontecimento:");
        String data = scanner.nextLine();
        System.out.println("Coloque o endereço do acontecimento:");
        String endereco = scanner.nextLine();
        Sinistro sinistro = new Sinistro(data, endereco, condutor, null, this);
        getListaSinistros().add(sinistro);
        System.out.println("Sinistro Gerado!");
        condutor.adicionaSinistro(condutor, null, this, sinistro);
    }

    public static SeguroPJ criaSeguroPJ(Scanner scanner, Seguradora seguradora, List<Sinistro> lSinistros, List<Condutor> lCondutors, Frota frota, ClientePJ cliente){
        System.out.println("Digite a data de início do seguro: ");
            String dataInicio = scanner.nextLine();

        System.out.println("Digite a data de fim do seguro: ");
            String dataFim = scanner.nextLine();

        // Chamar o construtor da classe SeguroPF com os valores lidos
        SeguroPJ seguroPJ = new SeguroPJ(dataInicio, dataFim, seguradora, 0, lSinistros, lCondutors, frota, cliente);
        seguroPJ.calcularValor(cliente, seguradora);

        return seguroPJ;
    }

    public void implementacaoSeguroPJ(Frota frota, Condutor condutor, Sinistro sinistro, Seguradora seguradora){
        if(seguradora != null)
            setSeguradora(seguradora);
        if(frota != null)
            setFrota(frota);
        if(condutor != null){
            autorizarCondutor(condutor);
            getListaCondutores().add(condutor);
        }
        if(sinistro != null)
            getListaSinistros().add(sinistro);
    }

    public static SeguroPJ buscaSeguroPJ(Seguradora seguradora, Scanner scanner){
        System.out.println("Digite a id do seguro em que deseja cancelar");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (SeguroPJ seguroPJ : seguradora.getListaSeguroPJs()){
            if(seguroPJ.getId() == id){
                return seguroPJ;
            }
        }
        throw new IllegalArgumentException("Seguro inválido, não foi encontrado.");

    }

}
