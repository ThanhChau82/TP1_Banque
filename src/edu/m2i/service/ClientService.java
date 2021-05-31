package edu.m2i.service;

import edu.m2i.entites.Client;

public interface ClientService {
	/**
	 * Enregistrer un client en bddMOCK
	 * @param client
	 */
	boolean saveClientMock(Client client);
	
	boolean saveClient(Client client);
	
	/**
	 * Chercher un client selon son id 
	 * @param id
	 * @return
	 */
	Client findById(int id);
	
	Client findByIdBdd(int id);	
	
	/**
	 * Afficher la liste des clients
	 */
	void afficherClients();
	
	/**
	 * Ajouter un client à la liste
	 * @param client
	 */
	void addClient(Client client);
	
}
