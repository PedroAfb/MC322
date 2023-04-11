package lab03;

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
}
