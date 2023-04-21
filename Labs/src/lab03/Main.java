package lab03;
import java.util.Scanner;
public class Main{

    public void imprimeObjetos(Seguradora seguradora, Cliente cliente, Scanner scan){
        System.out.println("Deseja se informar sobre os clientes cadastrados na seguradora? [S/N]");
        String str = scan.nextLine();
        if (str.equals("S")){
            seguradora.visualizarSinistro(cliente.getNome());
            seguradora.listarClientes();
            seguradora.listarSinistro();
        }
        System.out.println("Atendimento encerrado.");
    }
    public static void main(String [] args){
        Main main = new Main();
        boolean validacao;
        Scanner scan = new Scanner(System.in);
        String str;
        //Cliente 1
        Cliente cliente1 = new Cliente("Maria", "Av. Mar. Floriano Peixoto 23, centro, Campinas",
         "Mulher","Ensino médio completo", "Classe média", null, null);
        cliente1.implementacaoCliente(cliente1, scan);
        Veiculo veiculo1 = new Veiculo(null, null, null, 0);
        veiculo1.implementacaoVeiculo(veiculo1, scan);
        Seguradora seguradora = new Seguradora("Pedro Seguradora", "12991128382", "pedro.seguradora@gmail.com",
         "Rua Jean Nassif Mokarzel 101, Barão Geraldo, Campinas",null, null);

        //Definindo o Cliente 1 (Cliente PF)
        
            ClientePF clientePf1 = new ClientePF(cliente1.getNome(), cliente1.getEndereco(), cliente1.getGenero(), 
            cliente1.getEducacao(), cliente1.getClasseEconomica(), cliente1.getDataLicenca(), cliente1.getListaVeiculos(),
             "441.143.710-44", null);
            validacao = clientePf1.implementacaoClientePF(clientePf1, seguradora, scan, clientePf1.getCpf());
            if ( validacao == true){
                Sinistro sinistro1 = new Sinistro(0, "14/04/2023", "Rua Pitágoras, Cidade Universitária, Campinas", null, null, null);
                sinistro1.implementacaoSinistro(sinistro1, veiculo1, seguradora, cliente1, scan);
                seguradora.relacionandoObjetos(clientePf1, seguradora, veiculo1, sinistro1);
                str = clientePf1.toString();
                System.out.println(str);
            }
            // Adicionar outro sinistro para o cliente 1
            seguradora.geraSinistro(clientePf1, veiculo1, seguradora, scan);

         //Cliente 2
        Cliente cliente2 = new Cliente("Alberto", "Rua Antônio Bebeto, Cambuí, Campinas", "Homem", "Ensino médio completo",
         "Classe alta", null, null);
        cliente2.implementacaoCliente(cliente2,scan);
        Veiculo veiculo2 = new Veiculo(null, null, null, 0);
        veiculo2.implementacaoVeiculo(veiculo2, scan);
       
        //Definindo Cliente 2 (clientePF)
             ClientePF clientePf2 = new ClientePF(cliente2.getNome(), cliente2.getEndereco(), cliente2.getGenero(),
             cliente2.getEducacao(), cliente2.getClasseEconomica(), cliente2.getDataLicenca(), cliente2.getListaVeiculos(),
              "50a3419_0841.4", null);
             validacao = clientePf2.implementacaoClientePF(clientePf2, seguradora, scan, clientePf2.getCpf());
             if ( validacao == true){
                Sinistro sinistro2 = new Sinistro(0, "20/04/2023", "Rua Toninho Silva, Bairro da Ipica, Campinas",
                null, null, null);
                sinistro2.implementacaoSinistro(sinistro2, veiculo2, seguradora, cliente2, scan);       
                 seguradora.relacionandoObjetos(clientePf2, seguradora, veiculo2, sinistro2);
                 str = clientePf2.toString();
                System.out.println(str);
             }

         //CLiente 3
        Cliente cliente3 = new Cliente("Oficina do Marcão", "Rua Jorge Quente, Centro, Campinas", "Homem",
         "Ensino superior completo", "classe baixa", null, null);
        cliente3.implementacaoCliente(cliente3, scan);
        Veiculo veiculo3 = new Veiculo(null, null, null, 0);
        veiculo3.implementacaoVeiculo(veiculo3, scan);
          //Definindo o Cliente 3 (cliente PJ)
            ClientePJ clientePJ3 = new ClientePJ(cliente3.getNome(), cliente3.getEndereco(), cliente3.getGenero(),
            cliente3.getEducacao(), cliente3.getClasseEconomica(), cliente3.getDataLicenca(), cliente3.getListaVeiculos(),
             "05669429000190", null);
            validacao = clientePJ3.implementacaoClientePJ(clientePJ3, seguradora, scan, clientePJ3.getCnpj());
            if (validacao == true){
                Sinistro sinistro3 = new Sinistro(0, "21/04/2023", "Rua Jorge Filho, Centro, Campinas", null, null, null);
                sinistro3.implementacaoSinistro(sinistro3, veiculo3, seguradora, cliente3, scan);
                seguradora.relacionandoObjetos(clientePJ3, seguradora, veiculo3, sinistro3);
                str = clientePJ3.toString();
                System.out.println(str);
            }
        
        main.imprimeObjetos(seguradora, cliente1, scan);
        scan.close();
    }

}