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
        this.listaSinistros = listaSinistros != null ? listaSinistros : new ArrayList<>();
        this.listaCondutores = listaCondutores != null ? listaCondutores : new ArrayList<>();
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
