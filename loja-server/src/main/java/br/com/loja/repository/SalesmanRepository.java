package br.com.loja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.loja.entity.Salesman;
import br.com.loja.entity.Store;

public interface SalesmanRepository extends CrudRepository<Salesman, Integer> {

	Salesman findById(int salesmanId);

	List<Salesman> findAll();

	@Query("SELECT s FROM Salesman s WHERE s.store = ?1")
	List<Salesman> findByStore(Store store);

}
