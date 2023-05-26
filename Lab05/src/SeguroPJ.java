public class SeguroPJ extends Seguro {
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(int id, Date dataInicio, Date dataFim, Seguradora seguradora, int valorMensal, List <Sinistro> listaSinistros, List <Condutor> listaCondutores, Frota frota, ClientePJ cliente){
        super(id, DataInicio, DataFim, seguradora, ListaSinistros, ListaCondutores, valorMensal);
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
}
