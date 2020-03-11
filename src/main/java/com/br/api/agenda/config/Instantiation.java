package com.br.api.agenda.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.br.api.agenda.domain.Post;
import com.br.api.agenda.domain.User;
import com.br.api.agenda.dto.AuthorDTO;
import com.br.api.agenda.dto.CommentDTO;
import com.br.api.agenda.entities.Agenda;
import com.br.api.agenda.entities.Endereco;
import com.br.api.agenda.entities.Telefone;
import com.br.api.agenda.repository.AgendaRepository;
import com.br.api.agenda.repository.EnderecoRepository;
import com.br.api.agenda.repository.PostRepository;
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
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		enderecoRepository.deleteAll();
		telefoneRepository.deleteAll();
		agendaRepository.deleteAll();

		User user1 = new User(null, "Luiz Otávio", "luizotaviomartinsf@gmail.com");
		User user2 = new User(null, "André Luiz", "andreluiz@gmail.com");
		User user3 = new User(null, "Henrique Andrade", "henrique@gmail.com");
		User user4 = new User(null, "João Felipe", "joaofelipe@gmail.com");
		User user5 = new User(null, "Ingrid Martins", "ingridmartins@gmail.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(user1));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(user2));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(user3));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(user4));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(user5));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		user1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(user1);
		
		Agenda ag1 = new Agenda(null, "Luiz Otávio", sdf.parse("21/03/2018"), "01165793890");
		Agenda ag2 = new Agenda(null, "André Luiz", sdf.parse("21/03/2020"), "09245792310");
		Agenda ag3 = new Agenda(null, "Henrique Andrade", sdf.parse("21/03/1992"), "08321784398");
		Agenda ag4 = new Agenda(null, "João Felipe", sdf.parse("21/03/1987"), "01187634567");
		Agenda ag5 = new Agenda(null, "Ingrid Martins", sdf.parse("21/03/1996"), "09923476587");
		
		Endereco end1 = new Endereco(null, "Avenida", "Av.", "Paulista", "1401", "Sala 1409", "Centro", "São Paulo", "01311-000");
		Endereco end2 = new Endereco(null, "Rua", "R.", "Paulista", "145", "Casa 23", "Butantã", "São Paulo", "37823-789");
		Endereco end3 = new Endereco(null, "Praça", "Pc.", "Paulista", "90", "Conj A Apto 1104", "Pinheiros", "São Paulo", "93745-908");
		Endereco end4 = new Endereco(null, "Travessa", "Tv.", "Paulista", "12", "Casa 02", "Jardim Bonfiglioli", "São Paulo", "98345-893");
		Endereco end5 = new Endereco(null, "Jardim", "Jd.", "Paulista", "345", "Apto 1001", "Jardim Paulista", "São Paulo", "36723-745");
		
		Telefone tel1 = new Telefone(null, 21, 000, "992762617", Telefone.Tipo.Celular, "");
		Telefone tel2 = new Telefone(null, 11, 000, "31387822", Telefone.Tipo.Trabalho, "201");
		Telefone tel3 = new Telefone(null, 51, 000, "997462387", Telefone.Tipo.Celular, "");
		Telefone tel4 = new Telefone(null, 23, 000, "34873211", Telefone.Tipo.Trabalho, "301");
		Telefone tel5 = new Telefone(null, 27, 000, "32338778", Telefone.Tipo.Residencial, "");
		
		user1.getDados_agenda().add(ag1);
		user2.getDados_agenda().add(ag2);
		user3.getDados_agenda().add(ag3);
		user4.getDados_agenda().add(ag4);
		user5.getDados_agenda().add(ag5);
		
		user1.getEnderecos().add(end1);
		user2.getEnderecos().add(end2);
		user3.getEnderecos().add(end3);
		user4.getEnderecos().add(end4);
		user5.getEnderecos().add(end5);
		
		user1.getTelefones().add(tel1);
		user2.getTelefones().add(tel2);
		user3.getTelefones().add(tel3);
		user4.getTelefones().add(tel4);
		user5.getTelefones().add(tel5);
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));
		agendaRepository.saveAll(Arrays.asList(ag1, ag2, ag3, ag4, ag5));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5));
		telefoneRepository.saveAll(Arrays.asList(tel1, tel2, tel3, tel4, tel5));
		
	}
}
