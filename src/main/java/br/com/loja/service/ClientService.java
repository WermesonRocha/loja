package br.com.loja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.loja.entity.Client;
import br.com.loja.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private StoreService storeService;

	public Client addClient(Client client) {
		return clientRepository.save(client);
	}

	public Client updateClient(Client client) {
		Client c = clientRepository.findById(client.getId());
		if (c != null && storeService.getStore(client.getStore().getId()) != null) {
			c = client;
			return clientRepository.save(c);
		}
		return null;
	}

	public void deleteClient(int clientId) {
		clientRepository.deleteById(clientId);
	}
	
	public Client getClient(int clientId) {
		return clientRepository.findById(clientId);
	}
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}

}
