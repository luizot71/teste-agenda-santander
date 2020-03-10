package com.br.api.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.dto.TelefoneDTO;
import com.br.api.agenda.entities.Telefone;
import com.br.api.agenda.repository.TelefoneRepository;
import com.br.api.agenda.services.exception.ObjectNotFoundException;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository tel;
	
	public List<Telefone> findAll() {
		return tel.findAll();
	}
	
	public Telefone findById(String id) {
		Optional<Telefone> obj = tel.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public Telefone insert(Telefone obj) {
		return tel.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		tel.deleteById(id);
	}
	
	public Telefone fromDTO(TelefoneDTO objDto) {
		return new Telefone(objDto.getId(), objDto.getDdd(), objDto.getDdi(), objDto.getNumero(), objDto.getTipoTelefone(), objDto.getRamal());
	}

}
