package com.pedro;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.Scanner;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(String dataInicio, String dataFim, Seguradora seguradora, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, double valorMensal, Veiculo veiculo, ClientePF cliente){
        super(dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }
    public ClientePF getCliente() {
        return cliente;
    }
    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public boolean autorizarCondutor(Condutor condutor){
        if(condutor != null){
            if(!getListaCondutores().contains(condutor)){
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

    public int calculaIdade(Date dataNascimento) {
        // Suponha que a data de nascimento da pessoa está armazenada na variável 'dataNascimento'
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);

        // Obtém a data atual
        Calendar hoje = Calendar.getInstance();

        // Calcula a diferença entre as duas datas
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH)) {
            idade--;
        } else if (hoje.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH)) {
            idade--;
        }

        // A variável 'idade' agora contém a idade da pessoa
        return idade;

    }
    

    public void calcularValor(Cliente cliente, Seguradora seguradora){
        ClientePF clientePF = (ClientePF) cliente;
        double valor;
        int idade = calculaIdade(clientePF.getDataNascimento());
        int qntdVeiculos = clientePF.getListaVeiculos().size();
        int qntdSinistrosCondutor = 0;
        List <Sinistro> lSinistros = seguradora.getSinistrosPorCliente(clientePF);
        //Achar o objeto condutor correspondente ao cliente
        for(Condutor condutor: getListaCondutores()){
            if (condutor.getCpf().equals(clientePF.getCpf())){
                List <Sinistro> sinistrosPorCondutor = condutor.getListaSinistros();
                qntdSinistrosCondutor = sinistrosPorCondutor.size();
            }
        }

        int qntdSinistrosCliente =  lSinistros.size();
        if(idade < 30)
            valor = (CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_18_30.getValor() * (1 + 1/( qntdVeiculos +2) ) * (2 + qntdSinistrosCliente /10) * (5 + qntdSinistrosCondutor /10));
        else if( idade >= 30 && idade <= 60)
            valor = ( CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_30_60.getValor() * (1 + 1/( qntdVeiculos +2) ) * (2 + qntdSinistrosCliente /10) * (5 + qntdSinistrosCondutor /10) );
        else
            valor = ( CalcSeguro.VALOR_BASE.getValor() * CalcSeguro.FATOR_60_90.getValor() * (1 + 1/( qntdVeiculos +2) ) * (2 + qntdSinistrosCliente /10) * (5 + qntdSinistrosCondutor /10) );

        System.out.println("Valor do seguro: "+valor);
        setValorMensal(valor);

    }

    public static SeguroPF criarSeguroPF(Seguradora seguradora, Scanner scanner, List<Sinistro> lSinistros, List<Condutor> lCondutors, Veiculo veiculo, ClientePF cliente) {

        System.out.println("Digite a data de início do seguro: ");
            String dataInicio = scanner.nextLine();

        System.out.println("Digite a data de fim do seguro: ");
            String dataFim = scanner.nextLine();

        // Chamar o construtor da classe SeguroPF com os valores lidos
        SeguroPF seguroPF = new SeguroPF(dataInicio, dataFim, seguradora, lSinistros, lCondutors, 0, veiculo, cliente);

        return seguroPF;
    }

    public void implementacaoSeguroPF(Veiculo veiculo, Condutor condutor, Sinistro sinistro, Seguradora seguradora){
        if(seguradora != null)
            setSeguradora(seguradora);
        if(veiculo != null)
            setVeiculo(veiculo);
        if(condutor != null){
            autorizarCondutor(condutor);
            getListaCondutores().add(condutor);
        }
        if(sinistro != null)
            getListaSinistros().add(sinistro);
    }

    public void gerarSinistro(Scanner scanner, Condutor condutor) {
        System.out.println("Coloque a data do acontecimento:");
        String data = scanner.nextLine();
        System.out.println("Coloque o endereço do acontecimento:");
        String endereco = scanner.nextLine();
        Sinistro sinistro = new Sinistro(data, endereco, condutor, this, null);
        getListaSinistros().add(sinistro);
        condutor.adicionaSinistro(condutor, this, null, sinistro);
        System.out.println("Sinistro Gerado!");
    }
    
    public static SeguroPF buscaSeguroPF(Seguradora seguradora, Scanner scanner){
        seguradora.imprimirListaSegurosPFs();
        System.out.println("Digite a id do seguro em que deseja achar");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (SeguroPF seguroPF : seguradora.getListaSeguroPFs()){
            if(seguroPF.getId() == id){
                return seguroPF;
            }
        }
        throw new IllegalArgumentException("Seguro inválido, não foi encontrado.");

    }

    public void imprimirSeguroPF() {
    System.out.println("ID: " + getId());
    System.out.println("Data de Início: " + getDataInicio());
    System.out.println("Data de Fim: " + getDataFim());
    System.out.println("Lista de Sinistros: " + getListaSinistros());
    System.out.println("Lista de Condutores: " + getListaCondutores());
    System.out.println("Valor Mensal: " + getValorMensal());
    System.out.println("Veículo: " + getVeiculo());
    System.out.println("Cliente: " + getCliente());
}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SeguroPF {")
        .append("id=").append(getId())
        .append(", dataInicio=").append(getDataInicio())
        .append(", dataFim=").append(getDataFim())
        .append(", seguradora=").append(getSeguradora())
        .append(", listaSinistros=").append(getListaSinistros())
        .append(", listaCondutores=").append(getListaCondutores())
        .append(", valorMensal=").append(getValorMensal())
        .append(", veiculo=").append(veiculo)
        .append(", cliente=").append(cliente)
        .append('}');
        return sb.toString();
    }

}
