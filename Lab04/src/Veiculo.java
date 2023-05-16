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

public void implementacaoVeiculo( Veiculo veiculo, Scanner scanVeiculo){
		System.out.println("Coloque a placa do veículo");
        veiculo.setPlaca(scanVeiculo.nextLine());
        System.out.println("Coloque a marca do seu veículo:");
        veiculo.setMarca(scanVeiculo.nextLine());
        System.out.println("Coloque o modelo do seu veículo:");
        veiculo.setModelo(scanVeiculo.nextLine());
		System.out.println("Coloque o ano de fabricação do seu veículo:");
        veiculo.setAnoFabricacao(scanVeiculo.nextInt());
		scanVeiculo.nextLine();
}

public static Veiculo cadastrarVeiculo(Seguradora seguradora, Scanner scanner){
	System.out.println("Placa do veiculo:");
	scanner.nextLine();
	String placa = scanner.nextLine();
	System.out.println("modelo do veiculo:");
	String modelo = scanner.nextLine();
	System.out.println("marca do veiculo:");
	String marca = scanner.nextLine();
	System.out.println("Ano de fabricacao do veiculo:");
	int anoFabricaco= scanner.nextInt();
	System.out.println("Nome do dono do veiculo:");
	scanner.nextLine();
	String nomeCliente = scanner.nextLine();
	Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricaco);
	for ( Cliente cliente : seguradora.getListaClientes()){
		if (cliente.getNome().equals(nomeCliente))
		cliente.getListaVeiculos().add(veiculo);
		}

	// calcula valor seguro

	for (ClientePF clientePF: seguradora.getListaClientePFs()){
		if(clientePF.getNome().equals(nomeCliente))
			clientePF.calculaScore(clientePF);
	}

	for (ClientePJ clientePJ: seguradora.getListaClientePJs()){
		if(clientePJ.getNome().equals(nomeCliente))
			clientePJ.calculaScore(clientePJ);
	}

	return veiculo;
}

public String toString() {
	return "Veículo [placa=" + getPlaca() + ", modelo=" + getModelo() + ", marca=" + getMarca() + ", ano de fabricação=" + getAnoFabricacao() + "]";
}
}
