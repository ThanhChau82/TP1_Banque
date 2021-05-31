package edu.m2i.entites;

public class Admin {
	/**
	 * Id
	 */
	private Integer id;
	private String login;
	private String password;
	
	public Admin() {
		super();
	}	
	public Admin(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public Admin(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
