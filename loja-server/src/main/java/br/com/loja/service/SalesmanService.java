package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.entity.Salesman;
import br.com.loja.entity.Store;
import br.com.loja.repository.SalesmanRepository;

@Service
public class SalesmanService {
	@Autowired
	private SalesmanRepository salesmanRepository;
	@Autowired
	private StoreService storeService;

	public Salesman getSalesman(int salesmanId) {
		return salesmanRepository.findById(salesmanId);
	}

	public List<Salesman> getSalesmans() {
		return salesmanRepository.findAll();
	}

	public Salesman addSalesman(Salesman salesman) {
		return salesmanRepository.save(salesman);
	}

	public Salesman updateSalesman(Salesman salesman) {
		Salesman sales = salesmanRepository.findById(salesman.getSalesmanId());
		if (sales != null && storeService.getStore(salesman.getStore().getId()) != null) {
			sales = salesman;
			return salesmanRepository.save(sales);
		}
		return null;
	}

	public void deleteSalesman(int salesmanId) {
		salesmanRepository.deleteById(salesmanId);
	}

	public List<Salesman> getSalesmansByStore(Store store) {
		return salesmanRepository.findByStore(store);
	}

}
