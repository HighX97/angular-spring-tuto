package com.ouwasav.spring.service;

import java.util.Collection;
import java.util.Map;

import com.ouwasav.spring.models.*;

public interface UtilisateurService 
{
	
	Collection<Utilisateur> findAll();
	Utilisateur findOne(int id);
	Utilisateur create(Utilisateur u);
	Utilisateur update(Utilisateur u,int id);
	boolean delete(int id);

}
