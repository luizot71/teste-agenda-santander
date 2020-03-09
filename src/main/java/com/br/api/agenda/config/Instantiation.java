package com.br.api.agenda.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.api.agenda.domain.User;
import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.entities.Endereco;
import com.br.api.agenda.entities.Telefone;
import com.br.api.agenda.repository.AgendaRepository;
import com.br.api.agenda.repository.EnderecoRepository;
import com.br.api.agenda.repository.TelefoneRepository;
import com.br.api.agenda.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();

		User luiz = new User(null, "Luiz Otávio", "luizotaviomartinsf@gmail.com");
		User santander = new User(null, "André Luiz", "andreluiz@gmail.com");
		User bandepe = new User(null, "Henrique Andrade", "henrique@gmail.com");
		User webmotors = new User(null, "João Felipe", "joaofelipe@gmail.com");
		User realcorretora = new User(null, "Ingrid Martins", "ingridmartins@gmail.com");
		
		userRepository.saveAll(Arrays.asList(luiz, santander, bandepe, webmotors, realcorretora));
		
		
		Agenda ag1 = new Agenda("Luiz Otávio", "23/01/1980", "01165793890");
		Agenda ag2 = new Agenda("André Luiz", "23/01/1980", "09245792310");
		Agenda ag3 = new Agenda("Henrique Andrade", "23/01/1980", "08321784398");
		Agenda ag4 = new Agenda("João Felipe", "23/01/1980", "01187634567");
		Agenda ag5 = new Agenda("Ingrid Martins", "23/01/1980", "09923476587");
		
		agendaRepository.saveAll(Arrays.asList(ag1, ag2, ag3, ag4, ag5));
		
		
		Endereco end1 = new Endereco("Avenida", "Av.", "Paulista", "1401", "Sala 1409", "Centro", "São Paulo", "01311-000");
		Endereco end2 = new Endereco("Rua", "R.", "Paulista", "145", "Casa 23", "Butantã", "São Paulo", "37823-789");
		Endereco end3 = new Endereco("Praça", "Pc.", "Paulista", "90", "Conj A Apto 1104", "Pinheiros", "São Paulo", "93745-908");
		Endereco end4 = new Endereco("Travessa", "Tv.", "Paulista", "12", "Casa 02", "Jardim Bonfiglioli", "São Paulo", "98345-893");
		Endereco end5 = new Endereco("Jardim", "Jd.", "Paulista", "345", "Apto 1001", "Jardim Paulista", "São Paulo", "36723-745");
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5));
		
		
		Telefone tel1 = new Telefone(21, 000, "992762617", Telefone.Tipo.Celular, "");
		Telefone tel2 = new Telefone(11, 000, "31387822", Telefone.Tipo.Trabalho, "201");
		Telefone tel3 = new Telefone(51, 000, "997462387", Telefone.Tipo.Celular, "");
		Telefone tel4 = new Telefone(23, 000, "34873211", Telefone.Tipo.Trabalho, "301");
		Telefone tel5 = new Telefone(27, 000, "32338778", Telefone.Tipo.Residencial, "");
		
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4, tel5));
	}

}
