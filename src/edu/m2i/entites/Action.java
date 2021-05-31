package edu.m2i.entites;

public class Action implements Comparable<Action> {
	private int id;
	private String date_heure;
	private double montant;
	private String type;
	private int id_client;
	
	public Action() {
		super();
	}	
	
	public Action(double montant, String type, int id_client) {
		super();
		this.montant = montant;
		this.type = type;
		this.id_client = id_client;
	}

	public Action(String date_heure, double montant, String type, int id_client) {
		super();
		this.date_heure = date_heure;
		this.montant = montant;
		this.type = type;
		this.id_client = id_client;
	}

	public Action(int id, String date_heure, double montant, String type, int id_client) {
		super();
		this.id = id;
		this.date_heure = date_heure;
		this.montant = montant;
		this.type = type;
		this.id_client = id_client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDate_heure() {
		return date_heure;
	}

	public void setDate_heure(String date_heure) {
		this.date_heure = date_heure;
	}

	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", date_heure=" + date_heure + ", montant=" + montant + ", type=" + type
				+ ", id_client=" + id_client + "]";
	}

	@Override
	public int compareTo(Action action) {	
		return this.getId_client() - action.getId_client();
	}
}
