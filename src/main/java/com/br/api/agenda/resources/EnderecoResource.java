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

import com.br.api.agenda.dto.EnderecoDTO;
import com.br.api.agenda.entities.Endereco;
import com.br.api.agenda.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EnderecoDTO>> findAll(){
		
		List<Endereco> list = service.findAll();
		List<EnderecoDTO> listDto = list.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<EnderecoDTO> findById(@PathVariable String id) {
		
		Endereco obj = service.findById(id);
		
		return ResponseEntity.ok().body(new EnderecoDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody EnderecoDTO objDto) {
		Endereco obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
