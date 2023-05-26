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

    public boolean addVeiculo(Veiculo veiculo, Frota frota){
        for (Veiculo veiculo1 : frota.getListaVeiculos()){
            if (veiculo.getPlaca().equals(veiculo1.getPlaca())){
                System.out.println("Esse veículo já está nesta frota");
                return false;
            }
        }
        frota.getListaVeiculos().add(veiculo);
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo, Frota frota){
        int tamanho = frota.getListaVeiculos().size();
        if(tamanho == 0){
            System.out.println("Essa frota ainda não tem veículos");
            return false;
        }

        for(Veiculo veiculo2 : frota.getListaVeiculos()){
            if(veiculo.getPlaca().equals(veiculo2.getPlaca())){
                System.out.println("Veículo Removido");
                listaVeiculos.remove(veiculo2);
                return true;
            }
        }

            System.out.println("Erro! Esse veículo não se encontra nessa frota");
            return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frota [code=").append(code).append(", listaVeiculos=").append(listaVeiculos).append("]");
        return sb.toString();
    }
}
