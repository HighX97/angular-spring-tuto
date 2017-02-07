package com.ouwasav.spring.service;

import java.util.Map;

import com.ouwasav.spring.models.*;

public interface IUtilisateurService 
{
	
	Map<Integer,Utilisateur> findAll();
	Utilisateur findOne(int id);
	Utilisateur create(Utilisateur u);
	Utilisateur update(Utilisateur u);
	void delete(int id);

}
