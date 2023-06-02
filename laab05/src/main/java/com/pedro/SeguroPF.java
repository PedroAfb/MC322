package com.pedro;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, int valorMensal, Veiculo veiculo, ClientePF cliente){
        super(id, dataInicio, dataFim, seguradora, listaSinistros, listaCondutores, valorMensal);
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
    

    public double calcularValor(Cliente cliente, Seguradora seguradora){
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

        return valor;

    }

    public String toString() {
        return "SeguroPF {" +
                "id=" + getId() +
                ", dataInicio=" + getDataInicio() +
                ", dataFim=" + getDataFim() +
                ", seguradora=" + getSeguradora() +
                ", listaSinistros=" + getListaSinistros() +
                ", listaCondutores=" + getListaCondutores() +
                ", valorMensal=" + getValorMensal() +
                ", veiculo=" + veiculo +
                ", cliente=" + cliente +
                '}';
    }

}
