package br.com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.loja.entity.Store;

public interface StoreRepository extends CrudRepository<Store, Integer> {

	@Query("Select s from Store s WHERE s.id = ?1")
	Store getById(int id);

	List<Store> findAll();
	
	Store findById(int storeId);

}
