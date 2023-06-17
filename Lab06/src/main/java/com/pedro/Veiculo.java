package com.pedro;
import java.util.Scanner;
public class Veiculo {
    private String placa;
	private String marca;
	private String modelo;
	private int anoFabricaco;
	
//Construtor de classes
public Veiculo(String placa, String marca, String modelo, int anoFabricaco) {
	this.placa = placa;
	this.marca = marca;
	this.modelo = modelo;
	this.anoFabricaco = anoFabricaco;
	}
//Getters e setters
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}

public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public int getAnoFabricacao() {
	return anoFabricaco;
}
public void setAnoFabricacao(int anoFabricaco) {
	this.anoFabricaco = anoFabricaco;
}

public static Veiculo criarVeiculo(Scanner scanner) {
	System.out.println("Digite a placa do veículo:");
	String placa = scanner.nextLine();
	System.out.println("Digite a marca do veículo:");
	String marca = scanner.nextLine();
	System.out.println("Digite o modelo do veículo:");
	String modelo = scanner.nextLine();
	System.out.println("Digite o ano de fabricação do veículo:");
	int anoFabricacao = scanner.nextInt();
	scanner.nextLine(); // Limpa o buffer do scanner

	// Cria e retorna a instância do Veiculo com os atributos preenchidos
	return new Veiculo(placa, marca, modelo, anoFabricacao);
}

public static Veiculo buscaVeiculo(Frota frota, ClientePF clientePF, Scanner scanner){
	System.out.println("Digite a placa do veiculo:");
	String placa = scanner.nextLine();
	if (frota != null){
		for (Veiculo veiculo : frota.getListaVeiculos()){
			if(veiculo.getPlaca().equals(placa)){
				return veiculo;
			}
		}
	}
	else{
		for (Veiculo veiculo : clientePF.getListaVeiculos()){
			if(veiculo.getPlaca().equals(placa)){
				return veiculo;
			}
		}
	}

	throw new IllegalArgumentException("Veiculo inválido, não foi encontrado.");
}

public String toString() {
	return "Veículo [placa=" + getPlaca() + ", modelo=" + getModelo() + ", marca=" + getMarca() + ", ano de fabricação=" + getAnoFabricacao() + "]";
}
}
