package edu.m2i.entites;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String telephone;
	private int codeApplication;
	private double solde;
	
	public Client() {
		super();
	}

	public Client(String nom, String prenom, String email, String adresse, String telephone, int codeApplication,
			double solde) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.codeApplication = codeApplication;
		this.solde = solde;
	}

	public Client(Integer id, String nom, String prenom, String email, String adresse, String telephone,
			int codeApplication, double solde) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
		this.codeApplication = codeApplication;
		this.solde = solde;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCodeApplication() {
		return codeApplication;
	}

	public void setCodeApplication(int codeApplication) {
		this.codeApplication = codeApplication;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", codeApplication=" + codeApplication + ", solde=" + solde + "]";
	}
	
	

}
