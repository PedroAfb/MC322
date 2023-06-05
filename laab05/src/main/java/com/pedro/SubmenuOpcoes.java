package com.pedro;
/*
 * Define as constantes dos submenus
 */
public enum SubmenuOpcoes {
	CADASTRAR_CLIENTEPF("Cadastrar cliente PF"),
	CADASTRAR_CLIENTEPJ("Cadastrar cliente PJ"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	CADASTRAR_FROTA("Cadastrar frota"),
	AUTORIZAR_CONDUTOR("Autorizar Condutor"),
	AUTORIZAR_FROTA("Autorizar frota"),
	DESAUTORIZAR_CONDUTOR("Desautorizar condutor"),
	LISTAR_CLIENTES("Listar cliente"),
	LISTAR_SINISTROS("Listar sinistros"),
	LISTAR_VEICULOS("Listar veiculo"),
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
