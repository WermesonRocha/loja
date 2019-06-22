package br.com.loja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.loja.entity.Client;
import br.com.loja.entity.Salesman;
import br.com.loja.entity.Store;
import br.com.loja.service.StoreService;

@Controller
@RequestMapping("/api/store")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/{storeId}", method = RequestMethod.GET)
	public ResponseEntity<Store> getStore(@PathVariable("storeId") int storeId) {
		return new ResponseEntity<Store>(storeService.getStore(storeId), HttpStatus.OK);
	}

	@RequestMapping(value = "/stores", method = RequestMethod.GET)
	public ResponseEntity<List<Store>> getStores() {
		return new ResponseEntity<List<Store>>(storeService.getAllStores(), HttpStatus.OK);
	}

	@RequestMapping(value = "/client/{storeId}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllClient(@PathVariable("storeId") int storeId) {
		return new ResponseEntity<List<Client>>(storeService.getAllClients(storeId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/client/{storeId}/{search}", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllClientByName(@PathVariable("storeId") int storeId, @PathVariable("search") String search) {
		return new ResponseEntity<List<Client>>(storeService.getAllClientsWithSearch(storeId,search), HttpStatus.OK);
	}

	@RequestMapping(value = "/salesman/{storeId}", method = RequestMethod.GET)
	public ResponseEntity<List<Salesman>> getAllSalesman(@PathVariable("storeId") int storeId) {
		return new ResponseEntity<List<Salesman>>(storeService.getAllSalesmans(storeId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Store> updateStore(@RequestBody Store store) {
		Store stor = storeService.updateStore(store);
		if (stor != null)
			return new ResponseEntity<Store>(stor, HttpStatus.OK);
		return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{storeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Store> deleteStore(@PathVariable("storeId") int storeId) {
		if (storeService.getStore(storeId) != null) {
			storeService.deleteStore(storeId);
			return new ResponseEntity<Store>(HttpStatus.OK);
		}
		return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
	}

}
