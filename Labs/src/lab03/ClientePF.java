package lab03;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
    private String cpf;
    private Date dataNascimento;

    public ClientePF(String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos, String cpf, Date dataNascimento){
        super(nome, endereco, genero, educacao, classeEconomica, dataLicenca, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf () {
        return cpf ;
    }
    
    public void setCpf ( String cpf ) {
        this . cpf = cpf ;
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
        int tamanho = cpf.length();
        boolean verificador;
        for (int i=0;i<tamanho;i++){
            int ascii = (int) cpf.charAt(i);
            if ((ascii >= 0 && ascii <= 47) || (ascii >= 58 && ascii <= 127))	{
                cpf = cpf.replaceAll("" + cpf.charAt(i),"");
                int tamanho_atual = cpf.length();
                int diferenca = tamanho - tamanho_atual;
                i -= diferenca;
                tamanho -= diferenca;
            }
        }
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
    @Override
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
