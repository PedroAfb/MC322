import java.util.List;
import java.util.ArrayList;

public class Frota {
    private String code;
    private List <Veiculo> listaVeiculos;

    public Frota(String code, List <Veiculo> listaVeiculos){
        this.code = code;
        this.listaVeiculos = listaVeiculos != null ? listaVeiculos : new ArrayList<>();
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }
    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frota [code=").append(code).append(", listaVeiculos=").append(listaVeiculos).append("]");
        return sb.toString();
    }
}
