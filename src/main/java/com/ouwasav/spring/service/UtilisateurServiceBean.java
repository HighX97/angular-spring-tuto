package com.ouwasav.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ouwasav.spring.models.Utilisateur;
import com.ouwasav.spring.repository.UtilisateurRepository;


import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;

@Service
@Transactional(
		propagation = Propagation.SUPPORTS,
		readOnly=true)
public class UtilisateurServiceBean implements UtilisateurService {
	
	/*
	 * ISSUE - FIXED
	 * Using Spring Data Repositories with Spring Boot could not be found #1
	 * https://github.com/HighX97/maven-spring-tuto/issues/1
	 */
	@Autowired
	private UtilisateurRepository utilisateurRepository ;
	
	
	public Collection<Utilisateur> findAll() {
		//return utilisateurs_maps;
		return utilisateurRepository.findAll();
	}

	@Cacheable(
			value="utilisateurs",
			key ="#id")
	public Utilisateur findOne(int id) {
//		return utilisateurs_maps.get(id);
		return utilisateurRepository.findOne(id);
	}

	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly=false
			)
	@CachePut(value ="utilisateurs", key="#result.id")
	public Utilisateur create(Utilisateur u) {
//		return save_tools(u);
		Utilisateur u_to_update = utilisateurRepository.findOne(u.getId()) ;
		if (u_to_update != null)
		{
			throw new EntityExistsException();
		}	
		else
		{
			//Illustrate Tx rollback
			Utilisateur u_created = utilisateurRepository.save(u);
			if (u_created.getId() == 4L)
			{
				throw new RuntimeException("Roll me back!!!");
			}
		}

		return utilisateurRepository.save(u);
	}

	@Transactional(
			propagation = Propagation.REQUIRED,
			readOnly=false
			)	
	@CachePut(value ="utilisateurs", key="#id")
	public Utilisateur update(Utilisateur u,int id) throws NoResultException{
		System.err.println("update bef"+id);
//		return update_tools(u, id);
//		/*
		Utilisateur u_to_update = utilisateurRepository.findOne(id) ;
		if (u_to_update != null)
		{
			u_to_update.update(u);
			System.err.println("update aft: "+id);
			return utilisateurRepository.save(u_to_update);
		}
		else
		{
			throw new NoResultException();
		}
		
		
	}

	@CacheEvict(value ="utilisateurs",
			key="#id")
	public boolean delete(int id) {
		utilisateurRepository.delete(id);
//		return delete_tools(id);		
		return true;
	}
	
	@CacheEvict(value ="utilisateurs",
			allEntries=true)
	public void evictCache() {
		// TODO Auto-generated method stub
		
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
