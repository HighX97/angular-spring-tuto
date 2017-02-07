package com.ouwasav.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouwasav.spring.models.Utilisateur;
import com.ouwasav.spring.repository.UtilisateurRepository;

@Service
public class UtilisateurServiceBean implements UtilisateurService {
	
	
	@Autowired
	private UtilisateurRepository utilisateurRepository ;
	
	
	public Map<Integer, Utilisateur> findAll() {
		return utilisateurs_maps;
		//return ((Map<Integer, Utilisateur>) utilisateurRepository.findAll());
	}

	public Utilisateur findOne(int id) {
		return utilisateurs_maps.get(id);
		//return utilisateurRepository.findOne(id);
	}

	public Utilisateur create(Utilisateur u) {
		return save_tools(u);
		//return utilisateurRepository.save(u);
	}

	public Utilisateur update(Utilisateur u,int id) {
		return update_tools(u, id);
		/*
		if (utilisateurRepository.findOne(id) != null)
		{
			return utilisateurRepository.save(u);
		}
		return null;
		*/
		
	}

	public boolean delete(int id) {
		//utilisateurRepository.delete(id);
		return delete_tools(id);		
		//return true;
	}
	
	////////////////////////////////////////////////////
	
	  static List<Utilisateur> utilisateurs_list;
	  static Map<Integer,Utilisateur> utilisateurs_maps;

	  public UtilisateurServiceBean()
	  {
	    utilisateurs_list = new ArrayList<Utilisateur>();
	    utilisateurs_maps = new HashMap<Integer, Utilisateur>();
	    for (int i = 0 ; i < 25 ; i++)
	    {
	      Utilisateur u = new Utilisateur();
	      utilisateurs_list.add(u);
	      utilisateurs_maps.put(u.getId(), u);
	    }
	  }
	  
	private static Utilisateur save_tools(Utilisateur u_send)
	  {
		  System.err.println("save"+u_send.getId());
	    //Error Utilisateur already exist
	    if (utilisateurs_maps.containsKey(u_send.getId()))
	    {
	  	  System.err.println("utilisateurs_maps.containsKey(u_send.getId())");

	      return null;
	    }
	    //Create Utilisateur
	    utilisateurs_maps.put(u_send.getId(), u_send);
	    return u_send;
	  }
	  
	  private static Utilisateur update_tools(Utilisateur u_send, int id)
	  {
	    //Error Utilisateur not exist
	    if (! utilisateurs_maps.containsKey(id))
	    {
	      return null;
	    }
	    //Update Utilisateur

	    Utilisateur u_update = utilisateurs_maps.get(id);
	    utilisateurs_maps.remove(id);
	    u_update.update(u_send);
	    utilisateurs_maps.put(id, u_update);
	    return u_update;
	  }
	  
	  private static boolean delete_tools(int id)
	  {
	    //Error Utilisateur not exist
	    if (! utilisateurs_maps.containsKey(id))
	    {
	      return false;
	    }
	    //Update Utilisateur
	    utilisateurs_maps.remove(id);
	    return true;
	  }

}
