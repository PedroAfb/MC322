package com.pedro;
/*
 * Define as constantes dos submenus
 */
public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE("Cadastrar cliente"),
	CADASTRAR_VEICULO_CLIENTEPF("Cadastrar veiculo em um cliente físico"),
	CADASTRAR_FROTA("Cadastrar frota"),
	DESAUTORIZAR_CONDUTOR("Desautorizar condutor"),
	REMOVER_CLIENTE("Excluir cliente"),
	REMOVER_VEICULO_CLIENTE("Excluir veiculo"),
	REMOVER_VEICULO_FROTA("Excluir sininstro"),
	CANCELAR_SEGURO("Cancelar seguro"),
	LISTAR_CLIENTE_PF("Listar os clientes Pfs da seguradora"),
	LISTAR_CLIENTE_PJ("Listar os clientes Pjs da seguradora"),
	LISTAR_SEGURO_PF("Listar os seguros Pfs da seguradora"),
	LISTAR_SEGURO_PJ("Listar os seguros Pjs da seguradora"),
	LISTAR_SINISTRO_CONDUTOR_PF("Listar os sinistros de um condutor PF"),
	LISTAR_SINISTRO_CONDUTOR_PJ("Listar os sinistros de um condutor PJ"),
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
