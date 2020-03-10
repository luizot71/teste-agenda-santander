package com.br.api.agenda.dto;

import com.br.api.agenda.entities.Endereco;

public class EnderecoDTO {
	
	private String id;
	private String tipoEndereco;
    private String tipoLogradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    
    public EnderecoDTO() {
    	
    }
    
    public EnderecoDTO(Endereco obj) {
    	id = obj.getId();
    	tipoEndereco = obj.getTipoEndereco();
    	tipoLogradouro = obj.getTipoLogradouro();
    	logradouro = obj.getLogradouro();
    	numero = obj.getNumero();
    	complemento = obj.getComplemento();
    	bairro = obj.getBairro();
    	cidade = obj.getCidade();
    	cep = obj.getCep();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
}
