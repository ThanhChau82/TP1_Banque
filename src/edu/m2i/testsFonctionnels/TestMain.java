package edu.m2i.testsFonctionnels;

import java.util.ArrayList;
import java.util.List;

import edu.m2i.dao.ActionDAO;
import edu.m2i.dao.ActionDAOImpl;
import edu.m2i.entites.Action;
import edu.m2i.entites.Admin;
import edu.m2i.entites.Client;
import edu.m2i.service.ActionService;
import edu.m2i.service.ActionServiceImpl;
import edu.m2i.service.AdminService;
import edu.m2i.service.AdminServiceImpl;
import edu.m2i.service.ClientService;
import edu.m2i.service.ClientServiceImpl;

public class TestMain {
	 

	public static void main(String[] args) {
//		testAjoutClient();
		
		testAjoutAction();
		
//		testAuthentification();
	}

	private static void testAjoutAction() {
		ActionDAO actionDAO = new ActionDAOImpl();
		actionDAO.addAction(new Action(200.0, "Versement", 1), 1);
	}

	private static void testAjoutClient() {
		Client client = new Client("Chau", "Thanh", "test@exemple.com", "adresse", "+123", 2823, 3000.0);
		ClientService clientService = new ClientServiceImpl();
		clientService.saveClient(client);
	}

	private static void testAuthentification() {
		Admin admin = new Admin("123546789123", "123456789123");
		AdminService adminService = new AdminServiceImpl();
		adminService.authentifier(admin);
	}

}
