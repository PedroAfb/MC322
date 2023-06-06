package com.pedro;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Frota {
    private String code;
    private List <Veiculo> listaVeiculos;

    public Frota(String code, List <Veiculo> listaVeiculos){
        this.code = code;
        this.listaVeiculos = new ArrayList<>();
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

    public boolean addVeiculo(Veiculo veiculo){
        for (Veiculo veiculo1 : getListaVeiculos()){
            if (veiculo.getPlaca() == veiculo1.getPlaca()){
                System.out.println("Esse veículo já está nesta frota");
                return false;
            }
        }
        getListaVeiculos().add(veiculo);
        System.out.println("Veículo adicionado com sucesso");
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo){
        int tamanho = getListaVeiculos().size();
        if(tamanho == 0){
            System.out.println("Essa frota ainda não tem veículos");
            return false;
        }

        for(Veiculo veiculo2 : getListaVeiculos()){
            if(veiculo.getPlaca().equals(veiculo2.getPlaca())){
                System.out.println("Veículo Removido");
                listaVeiculos.remove(veiculo2);
                return true;
            }
        }

            System.out.println("Erro! Esse veículo não se encontra nessa frota");
            return false;
    }

    public static Frota criarFrota(Scanner scanner) {
        System.out.println("Digite o código da frota:");
        String codigo = scanner.nextLine();

        // Cria uma lista vazia para armazenar os veículos da frota
        List<Veiculo> listaVeiculos = new ArrayList<>();
        return new Frota(codigo, listaVeiculos);
    }

    public static Frota buscaFarota(ClientePJ clientePJ, Scanner scanner){
        
            System.out.println("Digite o code da frota:");
            String code = scanner.nextLine();
            for (Frota frota : clientePJ.getListaFrota()){
                if(frota.getCode().equals(code)){
                    return frota;
                }
            }
       
        throw new IllegalArgumentException("Frota inválida, não foi encontrada.");

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frota [code=").append(code).append(", listaVeiculos=").append(listaVeiculos).append("]");
        return sb.toString();
    }
}
