import java.util.Scanner;

public class Main{
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
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MenuOpcoes op;
		SubmenuOpcoes opSubmenu;
		Seguradora seguradora;

 		seguradora = Seguradora.cadastrarSeguradora(scanner);

			do {
				exibirMenuExterno();
 				op = lerOpcaoMenuExterno(scanner);
				if (op == MenuOpcoes.SAIR) {
					break;
				}
				switch(op){
					case GERAR_SINISTRO	:
						//achar o cliente
						System.out.println("Nome do cliente:");
						scanner.nextLine();
						String nomeCliente = scanner.nextLine();
						System.out.println("Placa do veiculo:");
						String placaVeiculo = scanner.nextLine();
							for (Cliente cliente: seguradora.getListaClientes()){
								if (cliente.getNome().equals(nomeCliente)){
									for(Veiculo veiculo: cliente.getListaVeiculos()){
										if(veiculo.getPlaca().equals(placaVeiculo))
											seguradora.geraSinistro(cliente, veiculo, seguradora, scanner);
									}
								}
							}
							System.out.println("Sinistro gerado");
		
						break;
					case TRANSFERIR_SEGURO:
							System.out.println("Pessoa que recebe o seguro:");
							scanner.nextLine();
							String cRecebe = scanner.nextLine();
							System.out.println("Pessoa que troca o seguro:");
							String cTroca = scanner.nextLine();
							for (Cliente cliente: seguradora.getListaClientes()){
								if (cliente.getNome().equals(cRecebe)){
									for( Cliente cliente2: seguradora.getListaClientes()){
										if (cliente2.getNome().equals(cTroca))
											seguradora.trocaSeguro(cliente2, cliente);
											seguradora.removerCliente(cliente2);

									}
								}
							}
							System.out.println("Seguro transferido e cliente " + cTroca + " removido");

						break;
					case CALCULAR_RECEITA:
							seguradora.calcularReceita(seguradora);
				}
				exibirSubmenu(op);
				opSubmenu = lerOpcaoSubmenu(op, scanner);

				switch(opSubmenu) {
					case CADASTRAR_CLIENTEPF:
						scanner.nextLine();
						System.out.println("Digite seu cpf:");
						String cpf = scanner.nextLine();
						boolean validaocao = Validacao.validarCPF(cpf);
						if (validaocao == true){
							ClientePF clientePf;
							clientePf = ClientePF.implementacaoClientePF(seguradora,scanner, cpf);
							System.out.println("cliente PF cadastrado");
						}
						else
							System.out.println("Cliente não cadastrado, cpf inválido.");
						
						break;
					case CADASTRAR_CLIENTEPJ:
						System.out.println("Digite seu cnpj:");
						scanner.nextLine();
						String cnpj = scanner.nextLine();
						boolean validacao = Validacao.ValidarCNPJ(cnpj);
						if (validacao == true){
						ClientePJ clientePJ;
						clientePJ = ClientePJ.implementacaoClientePJ(seguradora, scanner, cnpj);
						System.out.println("cliente PJ cadastrado");
						}
						else
							System.out.println("Cliente não cadastrado, cnpj inválido.");
		
						break;
					case CADASTRAR_SEGURADORA:
						seguradora = Seguradora.cadastrarSeguradora(scanner);
						System.out.println("Seguradora Cadastrada");

			
						break;
					case CADASTRAR_VEICULO:
						Veiculo veiculo;
						veiculo = Veiculo.cadastrarVeiculo(seguradora, scanner);


						break;
					case LISTAR_CLIENTES:
						System.out.println("Lista clientes:");
						seguradora.listarClientes();
	
						break;
					case LISTAR_SINISTROS:
						System.out.println("lista sinistros:");
						seguradora.listarSinistro();

						break;
					case LISTAR_VEICULOS:
						System.out.println("lista veiculos:");
						for (Cliente cliente : seguradora.getListaClientes()){
							for (Veiculo veiculo1: cliente.getListaVeiculos())
								System.out.println(veiculo1.toString());
						}
						break;
					case EXCLUIR_CLIENTE:
						scanner.nextLine();
						validacao = false;
						String nomeCliente = scanner.nextLine();
						for (Cliente cliente: seguradora.getListaClientes()){
							if (cliente.getNome().equals(nomeCliente)){
								seguradora.removerCliente(cliente);
								validacao = true;
								System.out.println("cliente excluido");
							}
						}
						
						if (validacao == false)
							System.out.println("cliente não foi excluido, nome do cliente não foi encontrado");


						break;
					case EXCLUIR_VEICULO:
						System.out.println("Digite a placa do veiculo:");
						scanner.nextLine();
						boolean tipoCliente = false;
						String placaVeiculo = scanner.nextLine();
						for (ClientePF cliente : seguradora.getListaClientePFs()){
							for (Veiculo veiculo1: cliente.getListaVeiculos()){
								if(veiculo1.getPlaca().equals(placaVeiculo)){
									cliente.getListaVeiculos().remove(veiculo1);
									cliente.calculaScore(cliente);
									tipoCliente = true;
									System.out.println("veiculo excluido");
									break;
								}
							}
						}

						if (tipoCliente == false){
							for (ClientePJ cliente : seguradora.getListaClientePJs()){
								for (Veiculo veiculo1: cliente.getListaVeiculos()){
									if(veiculo1.getPlaca().equals(placaVeiculo)){
										cliente.getListaVeiculos().remove(veiculo1);
										cliente.calculaScore(cliente);
										tipoCliente = true;
										System.out.println("veiculo excluido");
										tipoCliente = true;
										break;
									}
								}
							}
						}

						if (tipoCliente == false)
							System.out.println("veiculo não excluido, a placa e/ou o nome do cliente não foram encontrados");


						break;
					case EXCLUIR_SINISTRO:
						validacao = false;
						System.out.println("Informações dos sinistros:");
						seguradora.listarSinistro();
						System.out.println("Digite o ID do sinistro:");
						int idSinistro = scanner.nextInt();
						for (Sinistro sinistro: seguradora.getListaSinistros()){
							if(sinistro.getId() == idSinistro)
								seguradora.getListaSinistros().remove(sinistro);
								validacao = true;
								System.out.println("sinistro excluido");
								break;
						}

						if (validacao == false)
							System.out.println("sinistro não foi excluido, id não encontrado");


						break;
					//case VOLTAR:
					//	break;
					}
			}while(op != MenuOpcoes.SAIR);
			System.out.println("Saiu do sistema");
			scanner.close();
	}
}