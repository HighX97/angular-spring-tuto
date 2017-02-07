/**
*
*/
package com.ouwasav.spring.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ouwasav.spring.models.Utilisateur;


/**
* @author loort
*
*/
@RestController
public class UtilisateurController
{
  static List<Utilisateur> utilisateurs_list;
  static Map<Integer,Utilisateur> utilisateurs_maps;

  public UtilisateurController()
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

  //Methode

  private static Utilisateur save(Utilisateur u_send)
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
  
  private static Utilisateur update(Utilisateur u_send, int id)
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

  //Route
  @RequestMapping(value = "/utilisateur" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Utilisateur>> getUtilisateur_list(
  @RequestParam(value ="name" ,
  defaultValue="Resto") String name)
  {
    return new ResponseEntity<List<Utilisateur>>(utilisateurs_list, HttpStatus.OK);
  }

  @RequestMapping(value = "/utilisateur/{id}" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> getUtilisateurById_list(
  @PathVariable("id") int id )
  {
    Utilisateur u_find =null ;
    for(Utilisateur u :  utilisateurs_list)
    {
      if (u.getId() == id)
      {
        u_find = u;
        break;
      }
    }
    return new ResponseEntity<Utilisateur>(u_find, HttpStatus.OK);
  }


  @RequestMapping(value = "/utilisateur" ,
  method=RequestMethod.POST ,
  consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> createUtilisateur_list(@RequestBody Utilisateur utilisateur_send)
  {
    System.err.println(utilisateur_send);
    this.utilisateurs_list.add(utilisateur_send);
    return new ResponseEntity<Utilisateur>(utilisateur_send, HttpStatus.CREATED);
  }


  @RequestMapping(value = "/maps/utilisateur" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Map<Integer,Utilisateur>> getUtilisateur_maps(
  @RequestParam(value ="name" ,
  defaultValue="Resto") String name)
  {
    return new ResponseEntity<Map<Integer,Utilisateur>>(utilisateurs_maps, HttpStatus.OK);
  }

  @RequestMapping(value = "/maps/utilisateur/{id}" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> getUtilisateurById_maps(
  @PathVariable("id") int id )
  {
    Utilisateur u_find = utilisateurs_maps.get(id);
    return new ResponseEntity<Utilisateur>(u_find, HttpStatus.OK);
  }


  @RequestMapping(value = "/maps/utilisateur" ,
  method=RequestMethod.POST ,
  consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> createUtilisateur_maps(@RequestBody Utilisateur utilisateur_send)
  {
    Utilisateur utilisateur_save =  save(utilisateur_send);
    System.err.println("utilisateur_save :" +utilisateur_save  );
    System.err.println("utilisateur_send :" + utilisateur_send);
    if (utilisateur_save == null)
    {
        System.err.println("utilisateur_save :" +utilisateur_save  );
        System.err.println("utilisateur_send :" + utilisateur_send);
        return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Utilisateur>(utilisateur_send, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/maps/utilisateur/{id}" ,
  method=RequestMethod.PUT ,
  consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> updateUtilisateur_maps(@RequestBody Utilisateur utilisateur_send,
		  @PathVariable("id") int id )
  {
    Utilisateur utilisateur_save =  update(utilisateur_send,id);
    if (utilisateur_save == null)
    {
    	return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Utilisateur>(utilisateur_save, HttpStatus.CREATED);
  }
}
