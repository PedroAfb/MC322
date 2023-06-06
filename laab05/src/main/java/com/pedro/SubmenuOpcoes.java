package com.pedro;
/*
 * Define as constantes dos submenus
 */
public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_FROTA("Cadastrar frota"),
	DESAUTORIZAR_CONDUTOR("Desautorizar condutor"),
	REMOVER_CLIENTE("Excluir cliente"),
	REMOVER_VEICULO_CLIENTE("Excluir veiculo"),
	REMOVER_VEICULO_FROTA("Excluir sininstro"),
	CANCELAR_SEGURO("Cancelar seguro"),
	GERAR_SINISTRO("Gerar sinistro"),
	GERAR_SEGURO("Gerar seguro"),
	CALCULA_VALOR_PJ("Calcula o valor do seguro de um cliente pj"),
	CALCULA_VALOR_PF("Calcula o valor do seguro de um cliente pf"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuOpcoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}
