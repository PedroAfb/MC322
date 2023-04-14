package lab03;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private String nome;
	private String endereco;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private Date dataLicenca;
	private List <Veiculo> listaVeiculos;

	
	// Construtor de classes
	public Cliente(String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.genero = genero;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;
		this.dataLicenca = dataLicenca;
		this.listaVeiculos = listaVeiculos != null ? listaVeiculos : new ArrayList<>();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEducacao() {
		return educacao;
	}
	public void setCpf(String educacao) {
		this.educacao = educacao;
	}
	public Date getDataLicenca() {
		return dataLicenca;
	}
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getClasseEconomica() {
		return classeEconomica;
	}
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
	public List <Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(List <Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ").append(nome).append("\n");
		sb.append("Endereço: ").append(endereco).append("\n");
		sb.append("Educação: ").append(educacao).append("\n");
		sb.append("Gênero: ").append(genero).append("\n");
		sb.append("Classe Econômica: ").append(classeEconomica).append("\n");
		sb.append("Data de Licença: ").append(dataLicenca).append("\n");
		sb.append("Lista de Veículos:\n");
		for (Veiculo veiculo : listaVeiculos) {
			sb.append(veiculo.toString()).append("\n");
		}
		return sb.toString();
	}
} 