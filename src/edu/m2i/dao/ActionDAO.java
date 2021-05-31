package edu.m2i.dao;

import java.util.List;

import edu.m2i.entites.Action;

public interface ActionDAO {
	void saveAction(Action action);
	void addAction(Action action, int idClient);
}
