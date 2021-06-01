package edu.m2i.validators;

import edu.m2i.entites.Action;
import edu.m2i.entites.Admin;
import edu.m2i.entites.Client;

public class ValidateBanque {
	/**
	 * Login et password de longueur >=12.
	 * @param login
	 * @param password
	 * @return
	 */
	public boolean verifAdmin(Admin admin) {
		String login = admin.getLogin();
		String password = admin.getPassword();
		return (login != null && login.length() >= 12 && password != null && password.length() >= 12);
	}
	
	/**
	 * Vérifier client valide
	 * @param client
	 * @return
	 */
	public boolean verifClient(Client client) {
		boolean isChampsObligatoiresOK = verifChaineNonNull(client.getNom(), client.getPrenom(), 
				client.getEmail(), client.getAdresse(), client.getTelephone(), String.valueOf(client.getCodeApplication()));
		boolean isEmailOK = verifEmail(client.getEmail());
		boolean isTelOK = verifTel(client.getTelephone());
		boolean isCodeAppliOK = verifCodeAppli(client.getCodeApplication());
		
		return isChampsObligatoiresOK && isEmailOK && isTelOK && isCodeAppliOK;		
	}
	
	/**
	 * Vérifier action valide.
	 * @param action
	 * @param client
	 * @return
	 */
	public boolean verifAction(Action action, Client client) {
		boolean isChampsObligatoiresOK = verifChaineNonNull(action.getDate_heure(), String.valueOf(action.getMontant()), action.getType());
		boolean isMontantOK = verifMontant(action.getMontant());
		boolean isTypeOK = verifType(action.getType());
		boolean isRetraitOK = true;
		if ("Retrait".equalsIgnoreCase(action.getType())) {
			isRetraitOK = verifRetrait(action.getMontant(), client.getSolde());
		}	
		
		return isChampsObligatoiresOK && isMontantOK && isTypeOK && isRetraitOK;
	}
	
	/**
	 * Tous les champs de type chaine doivent être non null
	 * @param chaines
	 * @return
	 */
	public boolean verifChaineNonNull(String... chaines) {
		boolean isNonNull = true;
		for (String string : chaines) {
			if (string != null && !string.isBlank()) {
				isNonNull = isNonNull && true;
			} else {
				isNonNull = isNonNull && false;
			}
		}
		return isNonNull;		
	}
	
	/**
	 *  Le champ email doit contenir « @ » et « . »
	 * @param email
	 * @return
	 */
	public boolean verifEmail(String email) {
		return email.contains("@") && email.contains(".");
	}
	
	/**
	 * Le téléphone doit contenir +
	 * @param telephone
	 * @return
	 */
	public boolean verifTel(String telephone) {
		return telephone.contains("+");
	}
	
	/**
	 * Code application commence par 282
	 * @param codeAppli
	 * @return
	 */
	public boolean verifCodeAppli(int codeAppli) {
		return Integer.toString(codeAppli).startsWith("282");
//		return String.valueOf(codeAppli).startsWith("282");
	}
	
	/**
	 * Convertible en double
	 * @param value
	 * @return
	 */
	public double convertirDouble(String value) {		
		return Double.parseDouble(value);
	}
	
	/**
	 * Convertible en int
	 * @param value
	 * @return
	 */
	public int convertirInteger(String value) {		
		return Integer.parseInt(value);
	}
	
	/**
	 * Le montant doit être >20
	 * @param montant
	 * @return
	 */
	public boolean verifMontant(double montant) {
		return montant > 20;
	}
	
	/**
	 * Le type : retrait ou versement
	 * @param type
	 * @return
	 */
	public boolean verifType(String type) {
		return "Retrait".equalsIgnoreCase(type) || "Versement".equalsIgnoreCase(type);
	}
	
	/**
	 * Les actions de type retrait ne doivent pas dépassé le solde
	 * @param type
	 * @param montant
	 * @param solde
	 * @return
	 */
	public boolean verifRetrait(double montant, double solde) {		
		return montant <= solde; // méthode appelle test le type d'action.
	}
}
