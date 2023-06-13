package com.pedro;

	public abstract class Cliente {
		private String nome;
		private String endereco;
		private String email;
		private String telefone;

		
		// Construtor de classes
		public Cliente(String nome, String endereco, String email, String telefone) {
			this.nome = nome;
			this.endereco = endereco;
			this.email = email;
			this.telefone = telefone;
		}
		
		//Getters e setters
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEmail() {
			return email;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Nome: ").append(nome).append("\n");
			sb.append("Endereço: ").append(endereco).append("\n");
			sb.append("Telefone: ").append(telefone).append("\n");
			sb.append("Email: ").append(email).append("\n");
			return sb.toString();
		}
	} 