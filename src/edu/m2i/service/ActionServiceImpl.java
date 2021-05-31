package edu.m2i.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import edu.m2i.dao.ActionDAO;
import edu.m2i.dao.ActionDAOImpl;
import edu.m2i.entites.Action;
import edu.m2i.entites.Client;
import edu.m2i.validators.ValidateBanque;

public class ActionServiceImpl implements ActionService {
	public static List<Action> listeActions = new ArrayList();
	private ActionDAO actionDAO = new ActionDAOImpl();
	private ValidateBanque validator;

	@Override
	public boolean saveActionMock(Action action, Client client) {
		validator = new ValidateBanque();
		if (validator.verifAction(action, client)) {
			actionDAO.saveAction(action);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void saveActions(List<Action> actions, Client client) {
		validator = new ValidateBanque();
		for (Action action : actions) {
			if (validator.verifAction(action, client)) {
				actionDAO.addAction(action, client.getId());
			}
		}
	}
	
	@Override
	public boolean saveAction(Action action, Client client) {
		validator = new ValidateBanque();
		if (validator.verifAction(action, client)) {
			actionDAO.addAction(action, client.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Action findById(int id) {
		Stream<Action> filter = listeActions.stream()
				.filter(action -> action.getId() == id);
		Action action = null;
		if (filter.count() > 0) {
			action = filter.iterator().next();
		}
		return action;
	}

	@Override
	public void afficherActions() {
		for (Action action : listeActions) {
			System.out.println(action.toString());
		}
	}

	@Override
	public void addAction(Action action) {		
		Collections.sort(listeActions);
		listeActions.add(action);		
	}

	@Override
	public void afficherActionsClient(int idClient) {
		for (Action action : listeActions) {
			if (action.getId_client() == idClient) {
				System.out.println(action.toString());
			}
		}

	}

	public static List<Action> getListeActions() {
		return listeActions;
	}

	public static void setListeActions(List<Action> listeActions) {
		ActionServiceImpl.listeActions = listeActions;
	}

	

	

}
