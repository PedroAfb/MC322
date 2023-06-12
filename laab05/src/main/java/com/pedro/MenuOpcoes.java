package com.pedro;
/* enum para menu externo
Cada constante é vista como uma descrição e uma lista de outras constantes (que são as constantes do submenu)

new SubmenuOpcoes[]{} cria uma lista de constantes do submenu.
*/
public enum MenuOpcoes {
	CADASTRAR("Cadastros", new SubmenuOpcoes[] {
			SubmenuOpcoes.CADASTRAR_CLIENTE,
			SubmenuOpcoes.CADASTRAR_VEICULO_CLIENTEPF,
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
	LISTAR("Listar", new SubmenuOpcoes[]{
		SubmenuOpcoes.LISTAR_CLIENTE_PF,
		SubmenuOpcoes.LISTAR_CLIENTE_PJ,
		SubmenuOpcoes.LISTAR_CONDUTORES_PF,
		SubmenuOpcoes.LISTAR_CONDUTORES_PJ,
		SubmenuOpcoes.LISTAR_FROTA,
		SubmenuOpcoes.LISTAR_SEGURO_PF,
		SubmenuOpcoes.LISTAR_SEGURO_PJ,
		SubmenuOpcoes.LISTAR_SINISTRO_CONDUTOR_PF,
		SubmenuOpcoes.LISTAR_SINISTRO_CONDUTOR_PJ,
		SubmenuOpcoes.LISTAR_SINISTRO_SEGURO_PF,
		SubmenuOpcoes.LISTAR_SINISTRO_SEGURO_PJ,
		SubmenuOpcoes.LISTAR_VEICULO_CLIENTE,
		SubmenuOpcoes.LISTAR_VEICULO_FROTA
	}),
	DESAUTORIZAÇÕES("Desautorizar", new SubmenuOpcoes[]{
		SubmenuOpcoes.DESAUTORIZAR_CONDUTOR
	}),
	CALCULAR_VALOR("Calcular valor do seguro", new SubmenuOpcoes[]{
		SubmenuOpcoes.CALCULA_VALOR_PF,
		SubmenuOpcoes.CALCULA_VALOR_PJ
	}),
	ADICIONAR_VEICULO_FROTA("Adicionar veículo numa frota", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
	CALCULAR_RECEITA_SEGURADORA("Calcular Receita", new SubmenuOpcoes[] {SubmenuOpcoes.VOLTAR}),
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