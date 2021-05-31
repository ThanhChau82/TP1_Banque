package edu.m2i.service;

import java.util.List;

import edu.m2i.entites.Action;
import edu.m2i.entites.Client;

public interface ActionService {
	/**
	 * Enregistrer une action en bdd.
	 * @param action
	 * @param client
	 */
	boolean saveActionMock(Action action, Client client);
	
	void saveActions(List<Action> actions, Client client);
	
	boolean saveAction(Action action, Client client);
	
	/**
	 * Rechercher une action selon son id
	 * @param id
	 * @return
	 */
	Action findById(int id);
	
	/**
	 * Afficher la liste des transactions selon id du client
	 * @param actions
	 */
	void afficherActions();
	
	/**
	 * Afficher la liste des transactions d'un client par id.
	 * @param idClient
	 */
	void afficherActionsClient(int idClient);
	
	void addAction(Action action);
}
