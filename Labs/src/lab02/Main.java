package lab02;

public class Main {
    public static void main(String [] args){
        boolean validacao;
        Cliente cliente1 = new Cliente("Maria Eduarda", "576461940-85", "29/01/2004", 19,"Rua Abner Silva, 143,SP");
        Seguradora seguradora = new Seguradora("Seguradora do Pedro", "12991113232", "seguradora.pedro@gmail.com", "Rua Marechal Deodoro,401,SP");
        Veiculo veiculo1 = new Veiculo("DXT-0821", "Fiat", "Mobi");
        Sinistro sinistro1 = new Sinistro(0, "22/03/2023", "Rua Abner Silva, 03, SP");
        sinistro1.setId(sinistro1.GeraID(0));

        validacao = cliente1.validarCPF(cliente1.getCpf());
        if (validacao == false)
            System.out.println("O cpf está incorreto");
        
        else{
            String mensagem;
            mensagem = String.format("Olá,%nA %s pede que a cliente %s entre em contato com a gente pelo telefone: %s, ou pelo email: %s,"+
            " ou em nossa agência no endereço: %s. Além disso, peço que confirme os dados de seu acidente:%n%nVeículo: %s %s\n" +
            "Placa: %s%nEndereço e data: %s. Em %s%n%nSeu número de ocorrência: %d%n   Aguardamos seu retorno,%n     %s", seguradora.getNome(),
             cliente1.getNome(),seguradora.getTelefone(),seguradora.getEmail(),seguradora.getEndereco(),veiculo1.getMarca(),
             veiculo1.getModelo(),veiculo1.getPlaca(),sinistro1.getEndereco(),sinistro1.getData(),sinistro1.getId(),seguradora.getNome());
            System.out.println(mensagem);
        }

        
        
    }
}
