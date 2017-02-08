package com.ouwasav.spring.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Utilisateur 
{
	//Class
	private static int count = 0 ;
	
	private static String[] auto_nom = {"Alex","Bruno","Carl","David"};
	private static String auto_mail = "@mailxample.com";

	
	//Objet
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String nom;
	@Column
	private String phone;
	@Column
	private String mail;
	@Column
	private String password;
	
	
	//Constructeur
	public Utilisateur()
	{
		this.setNom(auto_nom[++count%4]+this.id);
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

	public Utilisateur update(Utilisateur u_send) 
	{
		if (u_send.getMail() != "")
		{
			this.mail =  u_send.getMail();
		}
		if (u_send.getPhone() != "")
		{
			this.phone =  u_send.getPhone();
		}
		if (u_send.getNom() != "")
		{
			this.nom =  u_send.getNom();
		}
		if (u_send.getPassword() != "")
		{
			this.password =  u_send.getPassword();
		}
		return this;
	}

}
