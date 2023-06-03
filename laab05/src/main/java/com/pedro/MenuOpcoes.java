package com.pedro;
/* enum para menu externo
Cada constante é vista como uma descrição e uma lista de outras constantes (que são as constantes do submenu)

new SubmenuOpcoes[]{} cria uma lista de constantes do submenu.
*/
public enum MenuOpcoes {
	CADASTROS("Cadastros", new SubmenuOpcoes[] {
			SubmenuOpcoes.CADASTRAR_CLIENTEPF,
			SubmenuOpcoes.CADASTRAR_CLIENTEPJ,
			SubmenuOpcoes.CADASTRAR_VEICULO,
			SubmenuOpcoes.CADASTRAR_SEGURADORA,
			SubmenuOpcoes.VOLTAR
	}),
	LISTAR("Listar", new SubmenuOpcoes[] {
			SubmenuOpcoes.LISTAR_CLIENTES,
			SubmenuOpcoes.LISTAR_SINISTROS,
			SubmenuOpcoes.LISTAR_VEICULOS,
			SubmenuOpcoes.VOLTAR
	}),
	REMOVER("Remover", new SubmenuOpcoes[] {
			SubmenuOpcoes.REMOVER_CLIENTE,
			SubmenuOpcoes.REMOVER_VEICULO,
			SubmenuOpcoes.REMOVER_SINISTRO,
			SubmenuOpcoes.VOLTAR}),
	GERAR("Gerar", new SubmenuOpcoes[]{

	}),

	AUTORIZAÇÕES("Autorizar", new SubmenuOpcoes[]{

	}),
	DESAUTORIZAÇÕES("Desautorizar", new SubmenuOpcoes[]{

	}),
	GERAR_SINISTRO("Gerar Sinistro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	TRANSFERIR_SEGURO("Transferir Seguro", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	SAIR("Sair", new SubmenuOpcoes[] {});
	
	//atributos
	private final String descricao;
	private final SubmenuOpcoes[] submenu;
	
	//Construtor
	MenuOpcoes(String descricao, SubmenuOpcoes[] submenu){
		this.descricao = descricao;
		this.submenu = submenu;
	}
	
	//getters
	public String getDescricao() {
		return descricao;
	}
	
	public SubmenuOpcoes[] getSubmenu() {
		return submenu;
	}
}