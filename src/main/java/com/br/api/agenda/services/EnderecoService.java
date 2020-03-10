package com.br.api.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.dto.EnderecoDTO;
import com.br.api.agenda.entities.Endereco;
import com.br.api.agenda.repository.EnderecoRepository;
import com.br.api.agenda.services.exception.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository end;
	
	public List<Endereco> findAll() {
		return end.findAll();
	}
	
	public Endereco findById(String id) {
		Optional<Endereco> obj = end.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Endereco insert(Endereco obj) {
		return end.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		end.deleteById(id);
	}
	
	public Endereco update(Endereco obj) {
		Endereco newObj = findById(obj.getId());
		updateData(newObj, obj);
		return end.save(newObj);
	}

	private void updateData(Endereco newObj, Endereco obj) {
		newObj.setTipoEndereco(obj.getTipoEndereco());
		newObj.setTipoLogradouro(obj.getTipoLogradouro());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setBairro(obj.getBairro());
		newObj.setCidade(obj.getCidade());
		newObj.setCep(obj.getCep());
	}
	
	public Endereco fromDTO(EnderecoDTO objDto) {
		return new Endereco(objDto.getId(), objDto.getTipoEndereco(), objDto.getTipoLogradouro(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCidade(), objDto.getCep());
	}

}
