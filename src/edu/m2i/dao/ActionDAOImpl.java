package edu.m2i.dao;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entites.Action;

public class ActionDAOImpl implements ActionDAO {
	private ConnexionBdd connexionBdd;

	@Override
	public void saveAction(Action action) {
		System.out.println(" Ajout " + action.toString() + " dans la bdd OK");	
	}

	@Override
	public void addAction(Action action, int idClient) {
		connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		try {
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
//			Date dateFormatee = formatter.parse(action.getDate_heure());
//			java.sql.Timestamp timestamp = new java.sql.Timestamp(dateFormatee.getTime());

			PreparedStatement prepareStatement = connexion.prepareStatement(
					"INSERT INTO `actions`(`montant`, `type`, `id_client`) " +		
					"VALUES ("  + action.getMontant() + ", '" +
								   action.getType() + "', " +
								   idClient + ")");
			prepareStatement.executeUpdate();
			System.out.println("Action ajoutée avec succès");
			connexion.close();
			System.out.println("Connexion fermée");
		} catch (SQLException e) {
			System.out.println("Ajout Action refusé");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
