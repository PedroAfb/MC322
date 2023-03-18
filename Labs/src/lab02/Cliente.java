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

public static boolean VerificadorCaracteresIguais(String str){
	char inicial = str.charAt(0);
	int tamanho = str.length();
	for (int i=0;i<tamanho;i++){
		if (str.charAt(i) != inicial)
			return false;
	}
	return true;
}

public static int calcularDigitoVerificador(String cpf) {
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

boolean validarCPF(String cpf){
	int tamanho = cpf.length();
	boolean verificador;
	cpf = cpf.replaceAll(".","");
	verificador = VerificadorCaracteresIguais(cpf);
	if (tamanho != 11)
		return false;
	else if (verificador == true){
		return false;
	}
	int digito1 = calcularDigitoVerificador(cpf.substring(0, 9));
    int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1);
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