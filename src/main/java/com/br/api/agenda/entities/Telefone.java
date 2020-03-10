package com.br.api.agenda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.api.agenda.domain.Post;

@Document(collection="telefone")
public class Telefone implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	public enum Tipo { Celular, Residencial, Trabalho }
    private int ddd;
    private int ddi;
    private String numero;
    private Tipo tipoTelefone;
    private String ramal;
    
    @DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
    
    public Telefone() {
    	
    }

	public Telefone(String id, int ddd, int ddi, String numero, Tipo tipoTelefone, String ramal) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.ddi = ddi;
		this.numero = numero;
		this.tipoTelefone = tipoTelefone;
		this.ramal = ramal;
	}

	public Telefone criaCelular(int ddd, int ddi, String numero, String ramal){
        return new Telefone(id, ddd, ddi, numero, Tipo.Celular, ramal);
    }

    public Telefone criaResidencial(int ddd, int ddi, String numero, String ramal){
        return new Telefone(id, ddd, ddi, numero, Tipo.Residencial, ramal);
    }

    public Telefone criaTrabalho(int ddd, int ddi, String numero, String ramal){
        return new Telefone(id, ddd, ddi, numero, Tipo.Trabalho, ramal);
    }

    public String formatoSimplesDDD(){
        return "("+ddd+") "+numero;
    }
    
    public String formatoSimplesDDI(){
        return "("+ddi+") "+numero;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Tipo getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(Tipo tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", ddi=" + ddi + ", numero=" + numero + ", tipoTelefone="
				+ tipoTelefone + ", ramal=" + ramal + "]";
	}

}
