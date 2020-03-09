package com.br.api.agenda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.api.agenda.entities.Telefone;

@Repository
public interface TelefoneRepository extends MongoRepository<Telefone, String> {

}
