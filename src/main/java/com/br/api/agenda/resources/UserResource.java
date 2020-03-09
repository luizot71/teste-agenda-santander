package com.br.api.agenda.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.agenda.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User luiz = new User("1", "Luiz Otávio", "luizotaviomartinsf@gmail.com");
		User santander = new User("2", "Santander", "santander@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(luiz, santander));
		
		return ResponseEntity.ok().body(list);
	}

}
