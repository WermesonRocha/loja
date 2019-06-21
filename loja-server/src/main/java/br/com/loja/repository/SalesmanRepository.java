package br.com.loja.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.loja.entity.Salesman;

public interface SalesmanRepository extends CrudRepository<Salesman, Integer> {

	Salesman findById(int salesmanId);

	List<Salesman> findAll();

}
