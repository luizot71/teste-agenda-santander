package com.br.api.agenda.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TelefoneDTO> findById(@PathVariable String id) {
		
		Telefone obj = service.findById(id);
		
		return ResponseEntity.ok().body(new TelefoneDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody TelefoneDTO objDto) {
		Telefone obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
