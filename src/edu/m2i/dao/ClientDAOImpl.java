package edu.m2i.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import edu.m2i.connexion.ConnexionBdd;
import edu.m2i.entites.Client;

public class ClientDAOImpl implements ClientDAO {
	private ConnexionBdd connexionBdd;

	@Override
	public void saveClient(Client client) {
		System.out.println("Ajout " + client.toString() + " dans la bdd OK");		
	}

	@Override
	public void addClient(Client client) {
		connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"INSERT INTO `client`(`nom`, `prenom`, `email`, `adresse`, `telephone`, `codeapplication`, `solde`) " +		
					"VALUES ('"  + client.getNom() + "', '" +
							       client.getPrenom() + "', '" +
							       client.getEmail() + "', '" +
							       client.getAdresse() + "', '" +
							       client.getTelephone() + "', " +
							       client.getCodeApplication() + ", " +
							       client.getSolde() + ")");
			prepareStatement.executeUpdate();
			System.out.println("Client ajouté avec succès");
			connexion.close();
			System.out.println("Connexion client fermée");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Client findById(int idClient) {
		connexionBdd = new ConnexionBdd();
		Connection connexion = connexionBdd.connexion;
		
		Client client = new Client();
		try {
			PreparedStatement prepareStatement = connexion.prepareStatement(
					"SELECT * FROM `client` WHERE id = " + idClient);
			ResultSet resultat = prepareStatement.executeQuery();
			System.out.println(resultat.toString());
			if (resultat.next()) {			
				System.out.println("Client trouvé");
				client = (Client) resultat.getObject(0);
				connexion.close();
				System.out.println("Connexion fermée");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}

}
