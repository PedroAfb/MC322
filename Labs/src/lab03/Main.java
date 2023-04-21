package lab03;
import java.util.Scanner;
public class Main{
        public static void main(String [] args){
        boolean validacao;
        String tipoCliente;
        Scanner scan = new Scanner(System.in);
        String str;
        //Cliente 1
        Cliente cliente1 = new Cliente("Maria", "Av. Mar. Floriano Peixoto 23, centro, Campinas", "Mulher","Ensino médio completo", "Classe média", null, null);
        cliente1.implementacaoCliente(cliente1, scan);
        Veiculo veiculo1 = new Veiculo(null, null, null, 0);
        veiculo1.implementacaoVeiculo(veiculo1, scan);
        Seguradora seguradora = new Seguradora("Pedro Seguradora", "12991128382", "pedro.seguradora@gmail.com",
         "Rua Jean Nassif Mokarzel 101, Barão Geraldo, Campinas",null, null);
        seguradora.implementacaoSeguradora(seguradora, scan);
        Sinistro sinistro1 = new Sinistro(0, "14/04/2023", "Rua Pitágoras, Cidade Universitária, Campinas", null, null, null);
        sinistro1.implementacaoSinistro(sinistro1, veiculo1, seguradora, cliente1, scan);

        //Definindo o objeto Cliente 1
        System.out.println("Cliente físico ou jurídico? [PF/PJ]");
        tipoCliente = scan.nextLine();
        if(tipoCliente.equals("PF")){
            ClientePF clientePf1 = new ClientePF(cliente1.getNome(), cliente1.getEndereco(), cliente1.getGenero(), cliente1.getEducacao(), cliente1.getClasseEconomica(), cliente1.getDataLicenca(), cliente1.getListaVeiculos(), null, null);
            validacao = clientePf1.implementacaoClientePF(clientePf1, seguradora, scan);
            if ( validacao == true)
                seguradora.relacionandoObjetos(clientePf1, seguradora, veiculo1, sinistro1);
                str = clientePf1.toString();
                System.out.println(str);
            }

        else{
            ClientePJ clientePJ1 = new ClientePJ(cliente1.getNome(), cliente1.getEndereco(), cliente1.getGenero(), cliente1.getEducacao(), cliente1.getClasseEconomica(), cliente1.getDataLicenca(), cliente1.getListaVeiculos(), null, null);
            validacao = clientePJ1.implementacaoClientePJ(clientePJ1, seguradora, scan);
            if (validacao == true)
                seguradora.relacionandoObjetos(clientePJ1, seguradora, veiculo1, sinistro1);
                str = clientePJ1.toString();
                System.out.println(str);
        }

         //Cliente 2
        Cliente cliente2 = new Cliente(null, null, null, null, null, null, null);
        cliente2.implementacaoCliente(cliente2, scan);
        Veiculo veiculo2 = new Veiculo(null, null, null, 0);
        veiculo2.implementacaoVeiculo(veiculo2, scan);
        Sinistro sinistro2 = new Sinistro(0, null, null, null, null, null);
        sinistro2.implementacaoSinistro(sinistro2, veiculo2, seguradora, cliente2, scan);

        //Definindo o objeto Cliente 2
         System.out.println("Cliente físico ou jurídico? [PF/PJ]");
         tipoCliente = scan.nextLine();
         if(tipoCliente.equals("PF")){
             ClientePF clientePf2 = new ClientePF(cliente2.getNome(), cliente2.getEndereco(), cliente2.getGenero(), cliente2.getEducacao(), cliente2.getClasseEconomica(), cliente2.getDataLicenca(), cliente2.getListaVeiculos(), null, null);
             validacao = clientePf2.implementacaoClientePF(clientePf2, seguradora, scan);
             if ( validacao == true)
                 seguradora.relacionandoObjetos(clientePf2, seguradora, veiculo2, sinistro2);
                 str = clientePf2.toString();
                System.out.println(str);
         }
 
         else{
             ClientePJ clientePJ2 = new ClientePJ(cliente2.getNome(), cliente2.getEndereco(), cliente2.getGenero(), cliente2.getEducacao(), cliente2.getClasseEconomica(), cliente2.getDataLicenca(), cliente2.getListaVeiculos(), null, null);
             validacao = clientePJ2.implementacaoClientePJ(clientePJ2, seguradora, scan);
             if (validacao == true)
                 seguradora.relacionandoObjetos(clientePJ2, seguradora, veiculo2, sinistro2);
                 str = clientePJ2.toString();
                System.out.println(str);
         }

         //CLiente 3
        Cliente cliente3 = new Cliente(null, null, null, null, null, null, null);
        cliente3.implementacaoCliente(cliente3, scan);
        Veiculo veiculo3 = new Veiculo(null, null, null, 0);
        veiculo3.implementacaoVeiculo(veiculo3, scan);
        Sinistro sinistro3 = new Sinistro(0, null, null, null, null, null);
        sinistro3.implementacaoSinistro(sinistro3, veiculo3, seguradora, cliente3, scan);

          //Definindo o objeto Cliente 3
        System.out.println("Cliente físico ou jurídico? [PF/PJ]");
        tipoCliente = scan.nextLine();
        if(tipoCliente.equals("PF")){
            ClientePF clientePf3 = new ClientePF(cliente3.getNome(), cliente3.getEndereco(), cliente3.getGenero(), cliente3.getEducacao(), cliente3.getClasseEconomica(), cliente3.getDataLicenca(), cliente3.getListaVeiculos(), null, null);
            validacao = clientePf3.implementacaoClientePF(clientePf3, seguradora, scan);
            if ( validacao == true)
                seguradora.relacionandoObjetos(clientePf3, seguradora, veiculo3, sinistro3);
                str = clientePf3.toString();
                System.out.println(str);
        }

        else{
            ClientePJ clientePJ3 = new ClientePJ(cliente3.getNome(), cliente3.getEndereco(), cliente3.getGenero(), cliente3.getEducacao(), cliente3.getClasseEconomica(), cliente3.getDataLicenca(), cliente3.getListaVeiculos(), null, null);
            validacao = clientePJ3.implementacaoClientePJ(clientePJ3, seguradora, scan);
            if (validacao == true)
                seguradora.relacionandoObjetos(clientePJ3, seguradora, veiculo3, sinistro3);
                str = clientePJ3.toString();
                System.out.println(str);
        }

        seguradora.listarClientes(cliente1.getNome());
        seguradora.visualizarSinistro(cliente2.getNome());
        seguradora.listarSinistro();
        veiculo1.toString();
        seguradora.toString();
        sinistro1.toString();
        scan.close();
    }

}