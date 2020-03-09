package com.br.api.agenda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.api.agenda.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
