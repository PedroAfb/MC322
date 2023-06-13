package com.pedro;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Frota {
    private final int code = GeraID();
    private List <Veiculo> listaVeiculos;

    public Frota(List <Veiculo> listaVeiculos){
        if (listaVeiculos == null)
            this.listaVeiculos = new ArrayList<>();
        else
            this.listaVeiculos = listaVeiculos;
    }

    public int getCode() {
        return code;
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
        // Cria uma lista vazia para armazenar os veículos da frota
        List<Veiculo> listaVeiculos = new ArrayList<>();
        return new Frota(listaVeiculos);
    }

    public static Frota buscaFarota(ClientePJ clientePJ, Scanner scanner){
        
            System.out.println("Digite o code da frota:");
            int code = scanner.nextInt();
            scanner.nextLine();
            for (Frota frota : clientePJ.getListaFrota()){
                if(frota.getCode() == code){
                    return frota;
                }
            }
       
        throw new IllegalArgumentException("Frota inválida, não foi encontrada.");

    }

    public void imprimirListaVeiculos() {
    if (listaVeiculos.isEmpty()) {
        System.out.println("A lista de veículos está vazia.");
    } else {
        System.out.println("Lista de Veículos:");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo.toString());
            System.out.println("-------------------------");
        }
    }
}
    public int GeraID(){
            // Gera um número int aleatório para o id
            Random gerador = new Random();
            return gerador.nextInt(100);
    
        }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Frota [code=").append(code).append(", listaVeiculos=").append(listaVeiculos).append("]");
        return sb.toString();
    }
}
