package com.br.api.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.api.agenda.dto.AgendaDTO;
import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.repository.AgendaRepository;
import com.br.api.agenda.services.exception.ObjectNotFoundException;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository agenda;
	
	public List<Agenda> findAll() {
		return agenda.findAll();
	}
	
	public Agenda findById(String id) {
		Optional<Agenda> obj = agenda.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Agenda insert(Agenda obj) {
		return agenda.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		agenda.deleteById(id);
	}
	
	public Agenda update(Agenda obj) {
		Agenda newObj = findById(obj.getId());
		updateData(newObj, obj);
		return agenda.save(newObj);
	}

	private void updateData(Agenda newObj, Agenda obj) {
		newObj.setName(obj.getName());
		newObj.setDateOfBirth(obj.getDateOfBirth());
		newObj.setCpf(obj.getCpf());
	}
	
	public Agenda fromDTO(AgendaDTO objDto) {
		return new Agenda(objDto.getId(), objDto.getName(), objDto.getDateOfBirth(), objDto.getCpf());
	}

}
