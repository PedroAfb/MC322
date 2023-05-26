public class SeguroPF extends Seguro {
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(int id, Date dataInicio, Date dataFim, Seguradora seguradora, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, int valorMensal, Veiculo veiculo, ClientePF cliente){
        super(id, DataInicio, DataFim, seguradora, ListaSinistros, ListaCondutores, valorMensal);
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
