package com.br.api.agenda.entities;

public class Telefone {
	
	public enum Tipo { Celular, Residencial, Trabalho }
    private int ddd;
    private int ddi;
    private String numero;
    private Tipo tipoTelefone;
    private String ramal;
    
    public Telefone() {
    	
    }

	public Telefone(int ddd, int ddi, String numero, Tipo tipoTelefone, String ramal) {
		
		this.ddd = ddd;
		this.ddi = ddi;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
		this.ramal = ramal;
	}
	
	public Telefone criaCelular(int ddd, int ddi, String numero, String ramal){
        return new Telefone(ddd, ddi, numero, Tipo.Celular, ramal);
    }

    public Telefone criaResidencial(int ddd, int ddi, String numero, String ramal){
        return new Telefone(ddd, ddi, numero, Tipo.Residencial, ramal);
    }

    public static Telefone criaTrabalho(int ddd, int ddi, String numero, String ramal){
        return new Telefone(ddd, ddi, numero, Tipo.Trabalho, ramal);
    }

    public String formatoSimplesDDD(){
        return "("+ddd+") "+numero;
    }
    
    public String formatoSimplesDDI(){
        return "("+ddi+") "+numero;
    }

	public int getDdd() {
		return ddd;
	}

	public int getDdi() {
		return ddi;
	}

	public String getNumero() {
		return numero;
	}

	public Tipo getTipoTelefone() {
		return tipoTelefone;
	}

	public String getRamal() {
		return ramal;
	}

	@Override
	public String toString() {
		return "Telefone [ddd=" + ddd + ", ddi=" + ddi + ", numero=" + numero + ", tipoTelefone=" + tipoTelefone
				+ ", ramal=" + ramal + "]";
	}

}
