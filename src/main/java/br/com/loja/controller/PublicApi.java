package br.com.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.loja.entity.Store;
import br.com.loja.service.StoreService;

@Controller
@RequestMapping("api/public")
public class PublicApi {
	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ResponseEntity<Store> addStore(@RequestBody Store store) {
		if (store.isValid())
			return new ResponseEntity<Store>(storeService.addStore(store), HttpStatus.OK);
		return new ResponseEntity<Store>(HttpStatus.BAD_REQUEST);
	}

}
