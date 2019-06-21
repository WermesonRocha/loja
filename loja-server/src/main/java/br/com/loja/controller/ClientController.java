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
import br.com.loja.service.ClientService;

@Controller
@RequestMapping("/api/client")
public class ClientController {
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<Client> getClient(@PathVariable("clientId") int clientId) {
		return new ResponseEntity<Client>(clientService.getClient(clientId), HttpStatus.OK);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getClients() {
		return new ResponseEntity<List<Client>>(clientService.getClients(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Client> updateClient(@RequestBody Client client) {
		Client c = clientService.updateClient(client);
		if (c != null)
			return new ResponseEntity<Client>(c, HttpStatus.OK);
		return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClient(@PathVariable("clientId") int clientId) {
		if (clientService.getClient(clientId) != null) {
			clientService.deleteClient(clientId);
			return new ResponseEntity<Client>(HttpStatus.OK);
		}
		return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
	}

}
