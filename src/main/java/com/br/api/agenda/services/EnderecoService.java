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
	
	public Endereco fromDTO(EnderecoDTO objDto) {
		return new Endereco(objDto.getId(), objDto.getTipoEndereco(), objDto.getTipoLogradouro(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCidade(), objDto.getCep());
	}

}
