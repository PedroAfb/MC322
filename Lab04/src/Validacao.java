public class Validacao {
    public static boolean VerificadorCaracteresIguais(String str){
        //Verifica se a string tem todos os caracteres iguais
        char inicial = str.charAt(0);
        int tamanho = str.length();
        for (int i=0;i<tamanho;i++){
            if (str.charAt(i) != inicial)
                return false;
        }
        return true;
    }

    public static boolean ValidarCNPJ(String cnpj){
        // função que verifica todas as regras para que um cnpj seja válido
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
    
    public static int calcularDigitoVerificador1(String cpf) {
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
    
    public static int calcularDigitoVerificador2(String cpf) {
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
    
    public static boolean validarCPF(String cpf){
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

    public static boolean validarNome(String nomw){
        return true;
    }
}
