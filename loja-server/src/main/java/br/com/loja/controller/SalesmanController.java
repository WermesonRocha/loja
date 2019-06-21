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

import br.com.loja.entity.Salesman;
import br.com.loja.service.SalesmanService;

@Controller
@RequestMapping("/api/salesman")
public class SalesmanController {
	@Autowired
	private SalesmanService salesmanService;

	@RequestMapping(value = "/{salesmanId}", method = RequestMethod.GET)
	public ResponseEntity<Salesman> getSalesman(@PathVariable("salesmanId") int salesmanId) {
		return new ResponseEntity<Salesman>(salesmanService.getSalesman(salesmanId), HttpStatus.OK);
	}

	@RequestMapping(value = "/salesmans", method = RequestMethod.GET)
	public ResponseEntity<List<Salesman>> getSalesmans() {
		return new ResponseEntity<List<Salesman>>(salesmanService.getSalesmans(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Salesman> updateSalesman(@RequestBody Salesman salesman) {
		Salesman sales = salesmanService.updateSalesman(salesman);
		if (sales != null)
			return new ResponseEntity<Salesman>(sales, HttpStatus.OK);
		return new ResponseEntity<Salesman>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{salesmanId}", method = RequestMethod.DELETE)
	public ResponseEntity<Salesman> deleteSalesman(@PathVariable("salesmanId") int salesmanId) {
		if (salesmanService.getSalesman(salesmanId) != null) {
			salesmanService.deleteSalesman(salesmanId);
			return new ResponseEntity<Salesman>(HttpStatus.OK);
		}
		return new ResponseEntity<Salesman>(HttpStatus.BAD_REQUEST);
	}

}
