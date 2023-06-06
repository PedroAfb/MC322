package com.pedro;
/* enum para menu externo
Cada constante é vista como uma descrição e uma lista de outras constantes (que são as constantes do submenu)

new SubmenuOpcoes[]{} cria uma lista de constantes do submenu.
*/
public enum MenuOpcoes {
	CADASTROS("Cadastros", new SubmenuOpcoes[] {
			SubmenuOpcoes.CADASTRAR_CLIENTE,
			SubmenuOpcoes.CADASTRAR_VEICULO,
			SubmenuOpcoes.CADASTRAR_FROTA,
			SubmenuOpcoes.VOLTAR
	}),
	REMOVER("Remover", new SubmenuOpcoes[] {
			SubmenuOpcoes.REMOVER_CLIENTE,
			SubmenuOpcoes.REMOVER_VEICULO_CLIENTE,
			SubmenuOpcoes.REMOVER_VEICULO_FROTA,
			SubmenuOpcoes.CANCELAR_SEGURO,
			SubmenuOpcoes.VOLTAR}),
	GERAR("Gerar", new SubmenuOpcoes[]{
		SubmenuOpcoes.GERAR_SEGURO,
		SubmenuOpcoes.GERAR_SINISTRO
	}),
	DESAUTORIZAÇÕES("Desautorizar", new SubmenuOpcoes[]{
		SubmenuOpcoes.DESAUTORIZAR_CONDUTOR
	}),
	CALCULAR_VALOR("Calcular valor do seguro", new SubmenuOpcoes[]{
		SubmenuOpcoes.CALCULA_VALOR_PF,
		SubmenuOpcoes.CALCULA_VALOR_PJ
	}),
	ADICIONAR_VEICULO("Adicionar veículo numa frota", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA("Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	AUTORIZAR_CONDUTOR("Autorizar condutor", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
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