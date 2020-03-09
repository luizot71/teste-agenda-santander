package com.br.api.agenda.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
