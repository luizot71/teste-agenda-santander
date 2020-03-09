package com.br.api.agenda.dto;

import com.br.api.agenda.entities.Telefone;

public class TelefoneDTO {
	
	public enum Tipo { Celular, Residencial, Trabalho }
    private int ddd;
    private int ddi;
    private String numero;
    private com.br.api.agenda.entities.Telefone.Tipo tipoTelefone;
    private String ramal;
    
    public TelefoneDTO() {
    	
    }
    
    public TelefoneDTO(Telefone obj) {
		ddd = obj.getDdd();
		ddi = obj.getDdi();
		numero = obj.getNumero();
		tipoTelefone = obj.getTipoTelefone();
		ramal = obj.getRamal();
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public com.br.api.agenda.entities.Telefone.Tipo getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(com.br.api.agenda.entities.Telefone.Tipo tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

}
