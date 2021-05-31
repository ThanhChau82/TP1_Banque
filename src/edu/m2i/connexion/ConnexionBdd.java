package edu.m2i.connexion;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnexionBdd {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DATABASE = "banque";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public com.mysql.jdbc.Connection connexion;
	
	{
		try {
			Class.forName(DRIVER).newInstance();
			connexion = (Connection) DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
			System.out.println("Connexion OK");
		} catch (Exception e) {
			System.out.println("Connexion KO" + e.getMessage());
		}
	}
}
