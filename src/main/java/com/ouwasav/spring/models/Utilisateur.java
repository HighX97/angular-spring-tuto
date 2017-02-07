package com.ouwasav.spring.models;

import java.util.List;

public class Utilisateur 
{
	//Class
	private static int count = 0 ;
	
	private static String[] auto_nom = {"Alex","Bruno","Carl","David"};
	private static String auto_mail = "@mailxample.com";

	
	//Objet
	private int id;
	private String nom;
	private String phone;
	private String mail;
	private String password;
	
	
	//Constructeur
	public Utilisateur()
	{
		this.setId(++count);
		this.setNom(auto_nom[this.id%4]+this.id);
		this.setMail(this.nom+auto_mail);
		this.setPassword("password");
	}	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
