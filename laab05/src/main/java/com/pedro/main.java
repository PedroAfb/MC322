package com.pedro;
import java.text.BreakIterator;
import java.util.Scanner;

public class main 
{

    //exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
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

    private static ClientePJ identificaClientePJ(Seguradora seguradora, Scanner scanner){
        System.out.println("Digite o cnpj do cliente");
        String cnpj = scanner.nextLine();
        for (ClientePJ cliente : seguradora.getListaClientePJs()){
            if(cliente.getCnpj().equals(cnpj)){
                return cliente;
            }
        }
        throw new IllegalArgumentException("Cliente PJ com CNPJ " + cnpj + " não encontrado.");
    }

    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        MenuOpcoes op;
        SubmenuOpcoes opSubmenu;
        
        Seguradora seguradora = new Seguradora("Seguradora do Pedro", "12991118381", "pedro.seguradora@gmail.com", 
        "Rua Ignácio", null,null , "92.917.008/0001-35", null, null);
        
        //ClientePF 1
        ClientePF clientePF = new ClientePF("Pedro", "Rua Jean", "M", "Ensino médio",
null, "894.739.120-48", "29/01/2004", "pedro193@gmail.com", "19990134032");
        Veiculo veiculo = new Veiculo("GZN-1319", "Toyota", "Corolla", 2018);
        clientePF.cadastrarVeiculo(veiculo);
        seguradora.cadastrarCliente(clientePF);
        



        ClientePJ clientePJ = new ClientePJ(10, "Maria", "Rua Lauro", "maria.r@gmail.com",
        "12991102384", "54.710.601/0001-17", "14/01/2023", null);
        Frota frota = new Frota("3245", null);
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
                    Veiculo veiculo5 = Veiculo.criarVeiculo(scanner);
                    ClientePJ clientePJ3 = identificaClientePJ(seguradora, scanner);
                    for (Frota frota2 : clientePJ3.getListaFrota()){
                        frota2.toString();
                    }
                    System.out.println("Digite o code da frota em que deseja adicionar um veículo:");
                    String code = scanner.nextLine();
                    clientePJ3.atualizarFrota(code, veiculo5, true);

                    break;

                case CALCULAR_RECEITA_SEGURADORA:
                    seguradora.calcularReceita();
                    break;

                case AUTORIZAR_CONDUTOR:
                    Condutor condutor3 = Condutor.criarCondutor(scanner);
                    System.out.println("Deseja autorizar esse condutor em um Seguro PF ou Jurídico? [p/j]");
                    String tipoSeguro = scanner.nextLine();
                    if (tipoSeguro == "p"){
                        System.out.println("Digite o cpf do cliente que contém esse seguro:");
                        String cpf = scanner.nextLine();
                        cpf = cpf.replaceAll("[^0-9]", "");
                        for (SeguroPF seguroPF : seguradora.getListaSeguroPFs()){
                            if(seguroPF.getCliente().getCpf().equals(cpf)){
                                seguroPF.autorizarCondutor(condutor3);
                            }
                        } 

                    }
                    else{
                        System.out.println("Digite o cnpj do cliente que contém esse seguro:");
                        String cnpj = scanner.nextLine();
                        cnpj = cnpj.replaceAll("[^0-9]", "");
                        for (SeguroPJ seguroPJ : seguradora.getListaSeguroPJs()){
                            if(seguroPJ.getCliente().getCnpj().equals(cnpj)){
                                seguroPJ.autorizarCondutor(condutor3);
                            }
                        } 
                    }
                    break;
            }
            exibirSubmenu(op);
            opSubmenu = lerOpcaoSubmenu(op, scanner);switch(opSubmenu) {
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
                    ClientePF clientePF3 = ClientePF.criarClientePF(scanner);
                    boolean verifica = clientePF3.cadastrarVeiculo(veiculo5);
                    if (verifica)
                        System.out.println("Veículo cadastrado com sucesso");
                    else
                        System.out.println("Erro ao cadastrar o veículo");
                    
                    break;

                case CADASTRAR_FROTA:
                    Frota frota2 = Frota.criarFrota(scanner);
                    try{
                        ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                        verifica = clientePJ3.cadastrarFrota(frota2);
                    if (verifica)
                        System.out.println("Frota cadastrada com sucesso");
                    else
                        System.out.println("Erro ao cadastrar a frota");

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
                    tipoCliente = scanner.nextLine();

                    if (tipoCliente.equals("f")){
                        System.out.println("Para gerar um seguro é preciso de informações do Cliente e veículo");
                        clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                        veiculo5 = Veiculo.buscaVeiculo(null,clientePF3, scanner);
                        seguradora.gerarSeguro(clientePF3, scanner, veiculo5, null);
                    }
                    else{
                        System.out.println("Para gerar um seguro é preciso de informações do Cliente, veículo e frota");
                        ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                        frota2 = Frota.buscaFarota(clientePJ3, scanner);
                        veiculo5 = Veiculo.buscaVeiculo(frota2, null, scanner);
                        seguradora.gerarSeguro(clientePJ3, scanner, veiculo5, frota2);
                    }

                    break;
                case GERAR_SINISTRO:
                System.out.println("Quer gerar um sinistro de pessoa física ou jurídica? [f/j]");
                tipoCliente = scanner.nextLine();
                if(tipoCliente.equals("f")){
                    SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    Condutor condutor3 = Condutor.buscaCondutor(seguroPF, null, scanner);
                    seguroPF.gerarSinistro(scanner, condutor3);
                }
                else{
                    SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    Condutor condutor3 = Condutor.buscaCondutor(null, seguroPJ, scanner);
                    seguroPJ.gerarSinistro(scanner, condutor3);
                }
                    break;
                
                case LISTAR_CLIENTE_PF:
                    seguradora.imprimirListaClientePFs();
                    break;
                case LISTAR_CLIENTE_PJ:
                    seguradora.imprimirListaClientePJs();
                    break;
                case LISTAR_CONDUTORES_PF:
                    SeguroPF seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    seguroPF.imprimirListaCondutor();
                    break;
                case LISTAR_CONDUTORES_PJ:
                    SeguroPJ seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    seguroPJ.imprimirListaCondutor();
                    break;
                case LISTAR_FROTA:
                    ClientePJ clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                    clientePJ3.imprimirListaFrotas();
                    break;
                case LISTAR_SEGURO_PF:
                    seguradora.imprimirListaSegurosPFs();
                    break;
                case LISTAR_SEGURO_PJ:
                    seguradora.imprimirListaSegurosPJs();
                    break;
                case LISTAR_SINISTRO_CONDUTOR_PF:
                    seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    Condutor condutor = Condutor.buscaCondutor(seguroPF, null, scanner);
                    condutor.imprimirListaSinistros();
                    break;
                case LISTAR_SINISTRO_CONDUTOR_PJ:
                    seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    condutor = Condutor.buscaCondutor(null, seguroPJ, scanner);
                    condutor.imprimirListaSinistros();
                    break;
                case LISTAR_SINISTRO_SEGURO_PF:
                    seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    seguroPF.imprimirListaSinistros();
                    break;
                case LISTAR_SINISTRO_SEGURO_PJ:
                    seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    seguroPJ.imprimirListaSinistros();
                    break;
                case LISTAR_VEICULO_CLIENTE:
                    clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                    clientePF3.imprimirListaVeiculos();
                    break;
                case LISTAR_VEICULO_FROTA:
                    clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                    clientePJ3.imprimirListaFrotas();
                    break;    
                case DESAUTORIZAR_CONDUTOR:
                System.out.println("Quer desautorizar um condutor de um seguro de pessoa física ou jurídica? [f/j]");
                tipoCliente = scanner.nextLine();
                if(tipoCliente.equals("f")){
                    seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    Condutor condutor3 = Condutor.buscaCondutor(seguroPF, null, scanner);
                    seguroPF.desautorizarCondutor(condutor3);
                }
                else{
                    seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    Condutor condutor3 = Condutor.buscaCondutor(null, seguroPJ, scanner);
                    seguroPJ.desautorizarCondutor(condutor3);
                }
                    break;

                case CALCULA_VALOR_PF:
                    seguroPF = SeguroPF.buscaSeguroPF(seguradora, scanner);
                    clientePF3 = ClientePF.buscaClientePF(seguradora, scanner);
                    seguroPF.calcularValor(clientePF3, seguradora);
                    break;

                case CALCULA_VALOR_PJ:
                    seguroPJ = SeguroPJ.buscaSeguroPJ(seguradora, scanner);
                    clientePJ3 = ClientePJ.buscaClientePJ(seguradora, scanner);
                    seguroPJ.calcularValor(clientePJ3, seguradora);
                    break;

                case VOLTAR:
                	break;
                }
        }while(op != MenuOpcoes.SAIR);

    }
}

/*Todos os objetos serão instanciados antes do menu (exceto a classe Seguro e Sinistro visto que o menu fará isso)
 * É preciso criar métodos de listar seguros,clientes e etc e deixar essa opção no menu
 */