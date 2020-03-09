package com.br.api.agenda.entities;

public class Endereco {
	
	private String tipoEndereco;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    
	public Endereco(String tipoEndereco, String tipoLogradouro, String logradouro, String numero, String complemento,
			String bairro, String cidade, String cep) {
		
		this.tipoEndereco = tipoEndereco;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Endereco [tipoEndereco=" + tipoEndereco + ", tipoLogradouro=" + tipoLogradouro + ", logradouro="
				+ logradouro + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", cep=" + cep + "]";
	}

}
