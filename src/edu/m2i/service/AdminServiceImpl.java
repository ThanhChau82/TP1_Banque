package edu.m2i.service;

import edu.m2i.dao.AdminDAO;
import edu.m2i.dao.AdminDAOImpl;
import edu.m2i.entites.Admin;

public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDAO = new AdminDAOImpl();

	@Override
	public boolean authentifier(Admin admin) {
		return adminDAO.authentifier(admin);
	}

}
