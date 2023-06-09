package com.pedro;
import java.util.List;
import java.util.Scanner;
import com.pedro.ClientePF;
import com.pedro.ClientePJ;
import com.pedro.Condutor;
import com.pedro.Frota;
import com.pedro.MenuOpcoes;
import com.pedro.Seguradora;
import com.pedro.SeguroPF;
import com.pedro.SeguroPJ;
import com.pedro.Sinistro;
import com.pedro.SubmenuOpcoes;
import com.pedro.Veiculo;

public class App {
        //exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	
	private static void exibirSubmenu(MenuOpcoes op) {
        //Implementar o método atualiza frota
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno(Scanner scanner) {
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op, Scanner scanner) {
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        MenuOpcoes op;
        SubmenuOpcoes opSubmenu;
        
        Seguradora seguradora = new Seguradora("Pedro", "129933403", "pedroaf@gmai.com", "Rua Jean", null, null, "58.804.275/0001-68", null, null, null, null, null, null, null, null, null);
        
        //ClientePF 1
        ClientePF clientePF = new ClientePF("Pedro", "Rua Jean", "M", "Ensino médio",
null, "894.739.120-48", "29/01/2004", "pedro193@gmail.com", "19990134032");
        Veiculo veiculo = new Veiculo("GZN-1319", "Toyota", "Corolla", 2018);
        clientePF.cadastrarVeiculo(veiculo);
        seguradora.cadastrarCliente(clientePF);
        



        ClientePJ clientePJ = new ClientePJ(10, "Maria", "Rua Lauro", "maria.r@gmail.com",
        "12991102384", "54.710.601/0001-17", "14/01/2023", null);
        Frota frota = new Frota(null);
        Veiculo veiculo3 = new Veiculo("PEA-4256", "chevrolet", "corsa", 2011);
        Veiculo veiculo4 = new Veiculo("JEI-3296", "Ford", "Escort", 1998);
        clientePJ.cadastrarFrota(frota);
        clientePJ.atualizarFrota(frota.getCode(), veiculo3, true);
        clientePJ.atualizarFrota(frota.getCode(), veiculo4, true);
        seguradora.cadastrarCliente(clientePJ);

        ClientePJ clientePJ2 = new ClientePJ(28, "Fabiana", "Rua Antônio", "fabiana.m@gmail.com",
        "19910829306", "92846102/9836-47", "08/06/2022", null);

        do {
            exibirMenuExterno();
             op = lerOpcaoMenuExterno(scanner);
            if (op == MenuOpcoes.SAIR) {
                break;
            }
            switch(op){
                case ADICIONAR_VEICULO_FROTA:
                    scanner.nextLine();
                    Veiculo veiculo5 = Veiculo.criarVeiculo(scanner);
                    ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                    for (Frota frota2 : clientePJ3.getListaFrota()){
                        System.out.println(frota2.toString());
                    }
                    System.out.println("Digite o code da frota em que deseja adicionar um veículo:");
                    int code = scanner.nextInt();
                    scanner.nextLine();
                    clientePJ3.atualizarFrota(code, veiculo5, true);

                    break;

                case CALCULAR_RECEITA_SEGURADORA:
                    seguradora.calcularReceita();
                    break;

                case AUTORIZAR_CONDUTOR:
                    Condutor condutor3 = Condutor.criarCondutor(scanner);
                    System.out.println("Deseja autorizar esse condutor em um Seguro PF ou PJ? [f/j]");
                    String tipoSeguro = scanner.nextLine();
                    if (tipoSeguro.equals("f")){
                        SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                        seguroPF.autorizarCondutor(condutor3);

                    }
                    else{
                        SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                        seguroPJ.autorizarCondutor(condutor3);
                    }
                    break;
            }
            exibirSubmenu(op);
            System.out.println();
            opSubmenu = lerOpcaoSubmenu(op, scanner);
            scanner.nextLine();
            switch(opSubmenu) {
                case CADASTRAR_CLIENTE:
                    System.out.println("Cliente físico ou jurídico? [f/j]");
                    String tipoCliente = scanner.nextLine();
                    if (tipoCliente.equals("f")){
                        ClientePF clientePF3 = ClientePF.criarClientePF(scanner);
                        seguradora.cadastrarCliente(clientePF3);
                    }
                    else{
                        ClientePJ clientePJ3 = ClientePJ.criarClientePJ(scanner);
                        seguradora.cadastrarCliente(clientePJ3);
                    }
                        
                    break;
                case CADASTRAR_VEICULO_CLIENTEPF:
                    Veiculo veiculo5 = Veiculo.criarVeiculo(scanner);
                    ClientePF clientePF3 = ClientePF.buscaClientePF(seguradora,scanner);
                    clientePF3.cadastrarVeiculo(veiculo5);
                
                    break;

                case CADASTRAR_FROTA:
                    Frota frota2 = Frota.criarFrota(scanner);
                    try{
                        ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                        clientePJ3.cadastrarFrota(frota2);
                    }catch(IllegalArgumentException e){
                        System.out.println("Cliente não encontrado");
                    }
                   
                    break;
                case REMOVER_CLIENTE:
                    System.out.println("Deseja remover um cliente jurídico ou físico? [f/j]");
                    tipoCliente = scanner.nextLine();
                    if(tipoCliente.equals("f")){
                       try{
                            clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                            seguradora.removerCliente(clientePF3);

                       }catch(IllegalArgumentException e){
                            System.out.println("Cliente não encontrado");

                       }
                    }
                    else{
                        try{
                            ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                            seguradora.removerCliente(clientePJ3);
                        }catch(IllegalArgumentException e){
                            System.out.println("Cliente não encontrado");
                        }
                    }
                    break;
                case REMOVER_VEICULO_CLIENTE:
                    try{clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                    veiculo5 = Veiculo.buscaVeiculo(null, clientePF3, scanner);
                    clientePF3.removerVeiculos(veiculo5);
                    }catch(IllegalArgumentException e){
                        System.out.println("Dados inválidos");
                    }
                    break;
                case REMOVER_VEICULO_FROTA:
                    try{
                        ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                        frota2 = Frota.buscaFarota(clientePJ3, scanner);
                        veiculo5 = Veiculo.buscaVeiculo(frota2, null, scanner);
                        clientePJ3.atualizarFrota(frota2.getCode(), veiculo5, false);

                    }catch(IllegalArgumentException e){
                        System.out.println("Dados inválidos");
                    }

                    break;

                case CANCELAR_SEGURO:
                    System.out.println("É um seguro de pessoa física ou jurídica? [f/j]");
                    tipoCliente = scanner.nextLine();
                    if (tipoCliente.equals("f")){
                        try{
                            SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                            seguradora.cancelarSeguro(seguroPF);
                        
                        }catch(IllegalArgumentException e){
                            System.out.println("Dados inválidos");           
                        }
                    }
                    else{
                        try{
                            SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                            seguradora.cancelarSeguro(seguroPJ);
                        
                        }catch(IllegalArgumentException e){
                            System.out.println("Dados inválidos");           
                        }
                    }

                    break;
                case GERAR_SEGURO:
                    System.out.println("Quer gerar um seguro de pessoa física ou jurídica? [f/j]");
                    tipoCliente = scanner.nextLine();

                    if (tipoCliente.equals("f")) {
                        try {
                            System.out.println("Para gerar um seguro é preciso de informações do Cliente e veículo");
                            clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                            veiculo5 = Veiculo.buscaVeiculo(null, clientePF3, scanner);
                            seguradora.gerarSeguro(clientePF3, scanner, veiculo5, null);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            System.out.println("Para gerar um seguro é preciso de informações do Cliente, veículo e frota");
                            ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                            frota2 = Frota.buscaFarota(clientePJ3, scanner);
                            veiculo5 = Veiculo.buscaVeiculo(frota2, null, scanner);
                            seguradora.gerarSeguro(clientePJ3, scanner, veiculo5, frota2);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case GERAR_SINISTRO:
                    System.out.println("Quer gerar um sinistro de pessoa física ou jurídica? [f/j]");
                    tipoCliente = scanner.nextLine();
                    if (tipoCliente.equals("f")) {
                        try {
                            SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                            Condutor condutor3 = Condutor.buscaCondutor(seguroPF, null, scanner);
                            seguroPF.gerarSinistro(scanner, condutor3);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                            Condutor condutor3 = Condutor.buscaCondutor(null, seguroPJ, scanner);
                            seguroPJ.gerarSinistro(scanner, condutor3);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case LISTAR_CLIENTE_PF:
                    seguradora.imprimirListaClientePFs();
                    break;

                case LISTAR_CLIENTE_PJ:
                    seguradora.imprimirListaClientePJs();
                    break;

                case LISTAR_SEGURO_PF:
                    seguradora.imprimirListaSegurosPFs();
                    break;

                case LISTAR_SEGURO_PJ:
                    seguradora.imprimirListaSegurosPJs();
                    break;

                case LISTAR_SINISTRO_CONDUTOR_PF:
                    try {
                        
                        for (ClientePF clientePF2 : seguradora.getListaClientePFs()){
                            List <Sinistro> lSinistro = seguradora.getSinistrosPorCliente(clientePF2);
                            for(Sinistro sinistro : lSinistro)
                                System.out.println(sinistro.toString());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case LISTAR_SINISTRO_CONDUTOR_PJ:
                    try {
                       for (ClientePJ clientePJ3 : seguradora.getListaClientePJs()){
                            List <Sinistro> lSinistro = seguradora.getSinistrosPorCliente(clientePJ3);
                            for(Sinistro sinistro : lSinistro)
                                System.out.println(sinistro.toString());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case DESAUTORIZAR_CONDUTOR:
                    System.out.println("Quer desautorizar um condutor de um seguro de pessoa física ou jurídica? [f/j]");
                    tipoCliente = scanner.nextLine();
                    if (tipoCliente.equals("f")) {
                        try {
                            SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                            Condutor condutor3 = Condutor.buscaCondutor(seguroPF, null, scanner);
                            seguroPF.desautorizarCondutor(condutor3);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                            Condutor condutor3 = Condutor.buscaCondutor(null, seguroPJ, scanner);
                            seguroPJ.desautorizarCondutor(condutor3);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case CALCULA_VALOR_PF:
                    try {
                        SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                        clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                        seguroPF.calcularValor(clientePF3, seguradora);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case CALCULA_VALOR_PJ:
                    try {
                        SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                        ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                        seguroPJ.calcularValor(clientePJ3, seguradora);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case VOLTAR:
                    break;
                }

        }while(op != MenuOpcoes.SAIR);
        System.out.println(seguradora.toString());
    }
}
