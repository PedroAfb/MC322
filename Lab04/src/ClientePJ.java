import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    //Construtor
    public ClientePJ (String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos, String cnpj, Date dataFundacao, int qtdeFuncionarios, double valorSeguro){
        super(nome, endereco, genero, educacao, classeEconomica, dataLicenca, listaVeiculos, valorSeguro);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }
    //Setters e Getters
    public String getCnpj () {
        return cnpj ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }
    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public boolean VerificadorCaracteresIguais(String str){
        //Verifica se a string tem todos os caracteres iguais
        char inicial = str.charAt(0);
        int tamanho = str.length();
        for (int i=0;i<tamanho;i++){
            if (str.charAt(i) != inicial)
                return false;
        }
        return true;
    }

    public boolean ValidarCNPJ(String cnpj){
        // função que  verifica todas as regras para que um cnpj seja válido
        boolean verificador;
        int tamanho = cnpj.length();
        cnpj = cnpj.replaceAll("[^0-9]", "");
        verificador = VerificadorCaracteresIguais(cnpj);
        if (tamanho != 14)
            return false;
        else if (verificador == true){
            return false;
        }
        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 5;
        for (int i = 0; i < 12; i++) {
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int dv1 = 11 - (soma % 11);
        if (dv1 >= 10) {
            dv1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
          
            soma += Character.getNumericValue(cnpj.charAt(i)) * peso;
            peso = (peso == 2) ? 9 : peso - 1;
        }
        int dv2 = 11 - (soma % 11);
        if (dv2 >= 10) {
            dv2 = 0;
    }
        int digitoCnpj1 = Character.getNumericValue(cnpj.charAt(12));
        int digitoCnpj2 = Character.getNumericValue(cnpj.charAt(13));

        if ((digitoCnpj1 == dv1) && (digitoCnpj2 == dv2))
            return true;
        else
            return false;
    }

    public static ClientePJ implementacaoClientePJ(Seguradora seguradora,Scanner scan, String cnpj){
        System.out.println("Seu nome:");
        String nome = scan.nextLine();
        System.out.println("Seu endereco:");
        String endereco = scan.nextLine();
        System.out.println("Seu genero:");
        String genero = scan.nextLine();
        System.out.println("Sua educacao:");
        String educacao = scan.nextLine();
        System.out.println("Sua classe economica:");
        String classeEconomica = scan.nextLine();
        System.out.println("Quantidade de funcionários:");
        int qtdeFuncionarios = scan.nextInt();

        System.out.println("Digite a data de licença:");
        scan.nextLine();
        String data = scan.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        ClientePJ clientePJ = new ClientePJ(nome, endereco, genero, educacao, classeEconomica, null, null, cnpj, null, qtdeFuncionarios, 0);

        try {
            clientePJ.setDataLicenca(format.parse(data));
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }

        System.out.println("Digite a data de Fundacao:");
        data = scan.nextLine();
        
        try {
            clientePJ.setDataFundacao(format.parse(data));;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }
        clientePJ.setListaVeiculos(new ArrayList<Veiculo>());
        seguradora.getListaClientes().add(clientePJ);
        seguradora.getListaClientePJs().add(clientePJ);
        return clientePJ;
    }
    public double calculaScore(ClientePJ cliente) {
        int qtdeCarros = cliente.getListaVeiculos().size();
        double valor= CalcSeguro.VALOR_BASE.getValor() * (1 + (cliente.getQtdeFuncionarios())/100) * qtdeCarros;
        cliente.setValorSeguro(valor);
        return valor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n");
        sb.append("Endereço: ").append(this.getEndereco()).append("\n");
        sb.append("Gênero: ").append(this.getGenero()).append("\n");
        sb.append("Educação: ").append(this.getEducacao()).append("\n");
        sb.append("Classe Econômica: ").append(this.getClasseEconomica()).append("\n");
        sb.append("Data da Licença: ").append(this.getDataLicenca()).append("\n");
        sb.append("Lista de Veículos: \n");
        for (Veiculo veiculo : this.getListaVeiculos()) {
            sb.append("  Modelo: ").append(veiculo.getModelo())
            .append(", Marca: ").append(veiculo.getMarca())
            .append(", Placa: ").append(veiculo.getPlaca())
            .append(", Ano de Fabricação: ").append(veiculo.getAnoFabricacao()).append("\n");
        }
        sb.append("CNPJ: ").append(this.getCnpj()).append("\n");
        sb.append("Valor Seguro: ").append(this.getValorSeguro()).append("\n");
        sb.append("Data de Fundação: ").append(this.getDataFundacao()).append("\n");
        return sb.toString();
}
}
