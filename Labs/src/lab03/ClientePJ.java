package lab03;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;


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

    public boolean implementacaoClientePJ(ClientePJ clientePJ1, Seguradora seguradora){
        Scanner scan = new Scanner(System.in);
        boolean validacao_pj;
       
        System.out.println("Digite a data de fundação:");
        String data = scan.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            clientePJ1.setDataFundacao(format.parse(data));;
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");
            e.printStackTrace();
        }

        System.out.println("Digite seu CNPJ:");
        clientePJ1.setCnpj(scan.nextLine());
        validacao_pj = clientePJ1.ValidarCNPJ(clientePJ1.getCnpj());
        seguradora.cadastrarCliente(clientePJ1);
        if (validacao_pj == false){
            System.out.println("Cnpj incorreto.");
            seguradora.removerCliente(clientePJ1);
            return false;
        }
        return true;
    }
}
