
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	import java.util.Scanner;
	import java.text.SimpleDateFormat;
	import java.text.ParseException;

	public class Cliente {
		private String nome;
		private String endereco;
		private String educacao;
		private String genero;
		private String classeEconomica;
		private Date dataLicenca;
		private List <Veiculo> listaVeiculos;
		private double valorSeguro;

		
		// Construtor de classes
		public Cliente(String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos, double valorSeguro) {
			this.nome = nome;
			this.endereco = endereco;
			this.genero = genero;
			this.educacao = educacao;
			this.classeEconomica = classeEconomica;
			this.dataLicenca = dataLicenca;
			this.listaVeiculos = listaVeiculos != null ? listaVeiculos : new ArrayList<>();
			this.valorSeguro = valorSeguro;
		}
		
		//Getters e setters
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEducacao() {
			return educacao;
		}
		public void setEducacao(String educacao) {
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
		public double getValorSeguro() {
			return valorSeguro;
		}
		public void setValorSeguro(double valorSeguro) {
			this.valorSeguro = valorSeguro;
		}


		public void implementacaoCliente(Cliente cliente, Scanner scanCliente){
			System.out.println("Digite a data da sua licenca do cliente:");
			String data = scanCliente.nextLine();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			cliente.setDataLicenca(format.parse(data));;
		} catch (ParseException e) {
			System.out.println("Formato de data inválido!");
			e.printStackTrace();
		}
	}

		public void calculaScore(Cliente cliente){
			/*double varivel = 1.9;
			int qtdeCarros = cliente.getListaVeiculos().size();
			double formula = CalcSeguro.VALOR_BASE.getValor() * varivel* qtdeCarros;
			return formula;*/
			//sobrecarga
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