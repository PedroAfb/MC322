import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

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
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op, Scanner scanner) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
				executarSubmenu(op,scanner );
				break;
			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				break;
			case TRANSFERIR_SEGURO:
				System.out.println("Executar metodo tranferir seguro");
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
				break;
			//case SAIR:
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu, Scanner scanner) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTEPF:
			System.out.println("Chamar metodo cadastrar cliente PF");
			String cpf = scanner.nextLine();
			boolean validaocao = Validacao.validarCPF(cpf);
			if (validaocao == true){
				ClientePF clientePf;
				clientePf = ClientePF.implementacaoClientePF(scanner, cpf);
			}

			break;
		case CADASTRAR_CLIENTEPJ:
			System.out.println("Chamar metodo cadastrar cliente PJ");
			String cnpj = scanner.nextLine();
			boolean validacao = Validacao.validarCPF(cnpj);
			if (validacao == true){
			ClientePJ clientePJ;
			clientePJ = ClientePJ.implementacaoClientePJ(scanner, cnpj);
			}
		case CADASTRAR_VEICULO:
			System.out.println("Chamar metodo cadastrar veiculo");
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Chamar metodo cadastrar seguradora");
			break;
		case LISTAR_CLIENTES:
			System.out.println("Chamar metodo listar clientes");
			break;
		case LISTAR_SINISTROS:
			System.out.println("Chamar metodo listar sinistros");
			break;
		case LISTAR_VEICULOS:
			System.out.println("Chamar metodo listar veiculos");
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Chamar metodo excluir cliente");
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Chamar metodo excluir veiculo");
			break;
		case EXCLUIR_SINISTRO:
			System.out.println("Chamar metodo excluir sinistro");
			break;
		//case VOLTAR:
		//	break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op, Scanner scanner) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op, scanner);
			executarOpcaoSubMenu(opSubmenu, scanner);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
	
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MenuOpcoes op;
		Seguradora seguradora = new Seguradora("Pedro Seguradora", "12991118686", "pedro.seguradora@gmail.com",
		"Rua Jean Mário, Campinas", null, null);
		// Cliente PF
		String cpf = "083.068.711-46";
		boolean verifica = Validacao.validarCPF(cpf);
		if (verifica == true){
			int ano = 2021;
			int mes = 3;
			int dia = 10;
			Calendar calendar = Calendar.getInstance();
			calendar.set(ano, mes - 1, dia); // Mês precisa ser ajustado para representação correta
			Date dataLicenca = calendar.getTime(); // Data Licença
			
			ano = 2004; // Data Aniversário
			mes = 4;
			dia = 25;
			calendar.set(ano, mes-1, dia);
			Date dataNascimento = calendar.getTime();
			ClientePF duda = new ClientePF("Duda", "Rua José Bonfim", "Mulher", "Ensino médio completo",
            "Classe média", dataLicenca, null, cpf, dataNascimento, 0);
			Veiculo palio = new Veiculo("LQH-01445", "Fiat", "Palio", 2014);
			seguradora.geraSinistro(duda, palio, seguradora, scanner);
			duda.calculaScore(duda);

		}

		//Cliente PJ
		String cnpj = "57.833.395/0001-20";
		verifica = Validacao.ValidarCNPJ(cnpj);
		if (verifica == true){
			int ano = 2009;
			int mes = 10;
			int dia = 30;
			Calendar calendar = Calendar.getInstance();
			calendar.set(ano, mes-1, dia);
			Date dataLicenca = calendar.getTime(); // Data Licença

			ano = 2023; //Data Fundação
			mes = 2;
			dia = 3;
			calendar.set(ano, mes-1,dia);
			Date dataFundacao = calendar.getTime();
			ClientePJ marcao = new ClientePJ("Oficina do Marcão", "Rua Jorge Quente,Campinas", "Homem","Ensino superior completo", "classe baixa", dataLicenca, null, cnpj, dataFundacao, 5,0.0);
			marcao.calculaScore(marcao);
			Veiculo corsa = new Veiculo("ABO-2018", "Chevrolet", "Corsa", 2011);
			seguradora.geraSinistro(marcao, corsa, seguradora, scanner);
		}


			do {
				exibirMenuExterno();
				op = lerOpcaoMenuExterno(scanner);
				executarOpcaoMenuExterno(op, scanner);
			}while(op != MenuOpcoes.SAIR);
			System.out.println("Saiu do sistema");
			scanner.close();
	}
}