package edu.m2i.dao;

import edu.m2i.entites.Client;

public interface ClientDAO {
	
	void saveClient(Client client);

	void addClient(Client client);
	
	Client findById(int idClient);
}
