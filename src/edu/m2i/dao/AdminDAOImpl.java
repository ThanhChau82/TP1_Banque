package edu.m2i.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entites.Admin;

public class AdminDAOImpl implements AdminDAO {
	private ConnexionBdd connexionBdd;

	@Override
	public boolean authentifier(Admin admin) {
		boolean isAuthentificationOK = false;
		connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"SELECT * FROM `admin` " +
					"WHERE login = '" + admin.getLogin() + "' AND password = '" + admin.getPassword() + "'");
			ResultSet resultat = prepareStatement.executeQuery();
			if (resultat.next()) {
				isAuthentificationOK = true;
				System.out.println("Authentification OK");
				connexion.close();
				System.out.println("Connexion fermée");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isAuthentificationOK;
	}

}
