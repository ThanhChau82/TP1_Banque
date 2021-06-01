package edu.m2i.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import edu.m2i.dao.ClientDAO;
import edu.m2i.dao.ClientDAOImpl;
import edu.m2i.entites.Client;
import edu.m2i.validators.ValidateBanque;

public class ClientServiceImpl implements ClientService {
	public static List<Client> listeClients = new ArrayList();
	
	private ClientDAO clientDAO = new ClientDAOImpl();
	private ValidateBanque validator;

	@Override
	public boolean saveClientMock(Client client) {
		validator = new ValidateBanque();
		if (validator.verifClient(client)) {
			clientDAO.saveClient(client);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean saveClient(Client client) {
		validator = new ValidateBanque();
		if (validator.verifClient(client)) {
			System.out.println("Verif OK");
			clientDAO.addClient(client);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Client findById(int id) {
		Stream<Client> filter = listeClients.stream()
				.filter(client -> client.getId() == id);
		Client client = null;
		if (filter.count() > 0) {
			client = filter.iterator().next();
		}	
		return client;
	}

	@Override
	public void afficherClients() {
		for (Client client : listeClients) {
			System.out.println(client.toString());
		}
		
	}

	@Override
	public void addClient(Client client) {		
			listeClients.add(client);		
	}

	public static List<Client> getListeClients() {
		return listeClients;
	}

	public static void setListeClients(List<Client> listeClients) {
		ClientServiceImpl.listeClients = listeClients;
	}

	@Override
	public Client findByIdBdd(int id) {		
		return clientDAO.findById(id);
	}

	

}
