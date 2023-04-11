package lab03;
import java.util.Date;
import java.util.List;


public class ClientePJ extends Cliente {
    String cnpj;
    Date dataFundacao;

    public ClientePJ (String nome, String endereco, String genero, String educacao, String classeEconomica, Date dataLicenca, List <Veiculo> listaVeiculos, String cnpj, Date dataFundacao){
        super(nome, endereco, genero, educacao, classeEconomica, dataLicenca, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }
    public String getCnpj () {
        return cnpj ;
    }
    
    public void setCnpj ( String cnpj ) {
        this . cnpj = cnpj ;
    }
    public Date getDataFundacao() {
        return dataFundacao;
    }
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public boolean ValidarCNPJ(String cnpj){
        boolean verificador;
        int tamanho;
        cnpj = cnpj.replaceAll("[^0,9]", "");
        verificador = VerificadorCaracteresIguais(cnpj);
        if (tamanho != 11)
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
    }
}
