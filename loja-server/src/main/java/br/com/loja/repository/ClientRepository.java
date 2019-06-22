package br.com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.loja.entity.Client;
import br.com.loja.entity.Store;

public interface ClientRepository extends CrudRepository<Client, Integer> {
	
	Client findById(int idClient);
	
	List<Client> findAll();

	@Query("SELECT c FROM Client c WHERE c.store = ?1")
	List<Client> findByStore(Store store);

	@Query("SELECT c FROM Client c WHERE c.store = ?1 AND c.name LIKE '?2%'")
	List<Client> searchByStoreAndSearch(Store store, String search);

}
