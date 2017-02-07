/**
 *
 */
package com.ouwasav.spring.controllers;

import java.util.ArrayList;
import java.util.List;

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
  List<Utilisateur> utilisateurs;
  public UtilisateurController()
  {
    utilisateurs = new ArrayList<Utilisateur>();
      utilisateurs.add(new Utilisateur());
      utilisateurs.add(new Utilisateur());
      utilisateurs.add(new Utilisateur());
      utilisateurs.add(new Utilisateur());
      utilisateurs.add(new Utilisateur());
  }

  @RequestMapping(value = "/utilisateur" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Utilisateur>> getUtilisateur(
      @RequestParam(value ="name" ,defaultValue="Resto") String name)
  {
      return new ResponseEntity<List<Utilisateur>>(utilisateurs, HttpStatus.OK);
  }

  @RequestMapping(value = "/utilisateur/{id}" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> getUtilisateurById(
      @PathVariable("id") int id )
  {
	  Utilisateur u_find =null ;
	  for(Utilisateur u :  utilisateurs)
	  {
		  if (u.getId() == id)
		  {
			  u_find = u;
			  break;
		  }
	  }
    return new ResponseEntity<Utilisateur>(u_find, HttpStatus.OK);
  }


    @RequestMapping(value = "/utilisateur" , method=RequestMethod.POST , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Utilisateur>> createUtilisateur(@RequestBody Utilisateur utilisateur_send)
    {
      System.err.println(utilisateur_send);
      this.utilisateurs.add(utilisateur_send);
      return new ResponseEntity<List<Utilisateur>>(this.utilisateurs, HttpStatus.CREATED);
    }
}
