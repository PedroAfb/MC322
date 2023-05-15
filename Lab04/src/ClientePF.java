
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;

public class ClientePF extends Cliente {
    private final String cpf;
    private Date dataNascimento;

    //Construtor
    public ClientePF(String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos, String cpf, Date dataNascimento, double valorSeguro){
        super(nome, endereco, genero, educacao, classeEconomica, dataLicenca, listaVeiculos, valorSeguro);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    //Getters e setters
    public String getCpf () {
        return cpf ;
    }
    
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
    
    public int calcularDigitoVerificador1(String cpf) {
        // Calcula o primeiro digito verificador do cpf
        int total = 0;
        for (int i = 0; i < cpf.length(); i++) {
            int multiplicador = 10 - i;
            total += Character.getNumericValue(cpf.charAt(i)) * multiplicador;
        }
        int resto = total % 11;
        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
    
    public int calcularDigitoVerificador2(String cpf) {
        // Calcula o segundo digito verificador do cpf
        int total = 0;
        for (int i = 0; i < cpf.length(); i++) {
            int multiplicador = 11 - i;
            total += Character.getNumericValue(cpf.charAt(i)) * multiplicador;
        }
        int resto = total % 11;
        if (resto == 0 || resto == 1) {
            return 0;
        } else {
            return 11 - resto;
        }
    }
    
    public boolean validarCPF(String cpf){
        // função que verifica todas as regras para que um cpf seja válido
        boolean verificador;
        cpf = cpf.replaceAll("[^0-9]", "");
        int tamanho = cpf.length();
        verificador = VerificadorCaracteresIguais(cpf);
        if (tamanho != 11)
            return false;
        else if (verificador == true){
            return false;
        }
        int digito1 = calcularDigitoVerificador1(cpf.substring(0, 9));
        int digito2 = calcularDigitoVerificador2(cpf.substring(0, 9) + digito1);
        int digitoCpf1 = Character.getNumericValue(cpf.charAt(9));
        int digitoCpf2 = Character.getNumericValue(cpf.charAt(10));
        if ((digito1 == digitoCpf1) & (digito2 == digitoCpf2)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean implementacaoClientePF(ClientePF clientePf1, Seguradora seguradora, Scanner scan, String cpf){
        boolean validacao;
        System.out.println("Digite a data de nascimento do cliente:");
        String data = scan.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    try {
        clientePf1.setDataNascimento(format.parse(data));;
    } catch (ParseException e) {
        System.out.println("Formato de data inválido!");
        e.printStackTrace();
    }
    validacao = clientePf1.validarCPF(clientePf1.getCpf());
    if (validacao == false){
        System.out.println("Cpf incorreto. Cliente não cadastrado");
        return false;
    }
    else{
        seguradora.cadastrarCliente(clientePf1);
    }
    return true;
    }

    public int calculaIdade(Date dataNascimento) {
        // Suponha que a data de nascimento da pessoa está armazenada na variável 'dataNascimento'
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);

        // Obtém a data atual
        Calendar hoje = Calendar.getInstance();

        // Calcula a diferença entre as duas datas
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        if (hoje.get(Calendar.MONTH) < dataNasc.get(Calendar.MONTH)) {
            idade--;
        } else if (hoje.get(Calendar.MONTH) == dataNasc.get(Calendar.MONTH) && hoje.get(Calendar.DAY_OF_MONTH) < dataNasc.get(Calendar.DAY_OF_MONTH)) {
            idade--;
        }

        // A variável 'idade' agora contém a idade da pessoa
        return idade;

    }
    
    public double calculaScore(ClientePF cliente) {
        int idade = calculaIdade(cliente.getDataNascimento());
        double qtdeCarros = cliente.getListaVeiculos().size();
        double valor = CalcSeguro.VALOR_BASE.getValor() * idade* qtdeCarros;
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
        sb.append("CPF: ").append(this.getCpf()).append("\n");
        sb.append("Data de Nascimento: ").append(this.getDataNascimento()).append("\n");
        return sb.toString();
}

}
