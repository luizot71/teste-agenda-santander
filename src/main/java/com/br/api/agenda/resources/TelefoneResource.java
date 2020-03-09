package com.br.api.agenda.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.agenda.dto.TelefoneDTO;
import com.br.api.agenda.entities.Telefone;
import com.br.api.agenda.services.TelefoneService;

@RestController
@RequestMapping(value="/telefones")
public class TelefoneResource {
	
	@Autowired
	private TelefoneService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TelefoneDTO>> findAll(){
		
		List<Telefone> list = service.findAll();
		List<TelefoneDTO> listDto = list.stream().map(x -> new TelefoneDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
