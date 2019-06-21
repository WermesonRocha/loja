package br.com.loja.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.loja.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	Client findById(int idClient);
	
	List<Client> findAll();

}
