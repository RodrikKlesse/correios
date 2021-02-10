package com.servico.correio.model;

public class Correio {
	private String servico;
	
	private String cep_origem;
	
	private String cep_destino;

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getCep_origem() {
		return cep_origem;
	}

	public void setCep_origem(String cep_origem) {
		this.cep_origem = cep_origem;
	}

	public String getCep_destino() {
		return cep_destino;
	}

	public void setCep_destino(String cep_destino) {
		this.cep_destino = cep_destino;
	}
}
