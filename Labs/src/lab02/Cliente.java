package lab02;

public class Cliente {
    private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
// Construtor de classes
public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
	this.nome = nome;
	this.cpf = cpf;
	this.dataNascimento = dataNascimento;
	this.idade = idade;
	this.endereco = endereco;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}

public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getDataNascimento() {
	return dataNascimento;
}
public void setDataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
public int getIdade() {
	return idade;
}
public void setIdade(int idade) {
	this.idade = idade;
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
} 