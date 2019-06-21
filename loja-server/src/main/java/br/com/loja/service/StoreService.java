package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.entity.Store;
import br.com.loja.repository.StoreRepository;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;

	public Store addStore(Store store) {
		return storeRepository.save(store);
	}

	public Store updateStore(Store store) {
		Store stor = storeRepository.getById(store.getId());
		if (stor != null) {
			stor = store;
			return storeRepository.save(stor);
		}
		return null;
	}

	public void deleteStore(int storeId) {
		storeRepository.deleteById(storeId);
	}
	
	public Store getStore(int storeId) {
		return storeRepository.findById(storeId);
	}

	public List<Store> getAllStores() {
		return storeRepository.findAll();
	}

}
