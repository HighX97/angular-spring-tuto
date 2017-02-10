/**
*
*/
package com.ouwasav.spring.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ouwasav.spring.models.Utilisateur;
import com.ouwasav.spring.service.EmailService;
import com.ouwasav.spring.service.UtilisateurService;
import com.ouwasav.spring.service.UtilisateurServiceBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
* @author loort
*
*/
@RestController
public class UtilisateurController
{

	@Autowired
	private UtilisateurService utilisateurService;
	

	  /**
	   * The EmailService business service.
	   */
	  @Autowired
	  private EmailService emailService;
	  
	    private Logger logger = LoggerFactory.getLogger(this.getClass());


  static List<Utilisateur> utilisateurs_list;
  static Map<Integer,Utilisateur> utilisateurs_maps;

  public UtilisateurController()
  {
	  //utilisateurService = new UtilisateurServiceBean();
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



  //Route
  @CrossOrigin
  @RequestMapping(value = "/utilisateur" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Utilisateur>> getUtilisateur_list(
  @RequestParam(value ="name" ,
  defaultValue="Resto") String name)
  {
    return new ResponseEntity<List<Utilisateur>>(utilisateurs_list, HttpStatus.OK);
  }

  @CrossOrigin
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
    ResponseEntity<Utilisateur> response=new ResponseEntity<Utilisateur>(u_find, HttpStatus.OK); 
    
    return response;
  }


  @CrossOrigin
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

  @CrossOrigin
  @RequestMapping(value = "/maps/utilisateur" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<Utilisateur>> getUtilisateur_maps(
  @RequestParam(value ="name" ,
  defaultValue="Resto") String name)
  {
    return new ResponseEntity<Collection<Utilisateur>>(utilisateurService.findAll(), HttpStatus.OK);
  }

  @CrossOrigin
  @RequestMapping(value = "/maps/utilisateur/{id}" ,
  method=RequestMethod.GET ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> getUtilisateurById_maps(
  @PathVariable("id") int id )
  {
    Utilisateur u_find = utilisateurs_maps.get(id);
    return new ResponseEntity<Utilisateur>(utilisateurService.findOne(id), HttpStatus.OK);
  }

  @CrossOrigin
  @RequestMapping(value = "/maps/utilisateur/{id}" ,
  method=RequestMethod.DELETE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> deleteUtilisateurById_maps(
  @PathVariable("id") int id )
  {
	    boolean utilisateur_delete =   utilisateurService.delete(id);
	    if (utilisateur_delete == false)
	    {
	    	return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return new ResponseEntity<Utilisateur>(HttpStatus.OK);
  }


  @CrossOrigin
  @RequestMapping(value = "/maps/utilisateur" ,
  method=RequestMethod.POST ,
  consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> createUtilisateur_maps(@RequestBody Utilisateur utilisateur_send)
  {
    Utilisateur utilisateur_save =  utilisateurService.create(utilisateur_send);
    System.err.println("utilisateur_save :" +utilisateur_save  );
    System.err.println("utilisateur_send :" + utilisateur_send);
    if (utilisateur_save == null)
    {
        System.err.println("utilisateur_save :" +utilisateur_save  );
        System.err.println("utilisateur_send :" + utilisateur_send);
        return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Utilisateur>(utilisateur_save, HttpStatus.CREATED);
  }

  @CrossOrigin
  @RequestMapping(value = "/maps/utilisateur/{id}" ,
  method=RequestMethod.PUT ,
  consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,
  produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> updateUtilisateur_maps(@RequestBody Utilisateur utilisateur_send,
		  @PathVariable("id") int id )
  {
    Utilisateur utilisateur_save =  utilisateurService.update(utilisateur_send,id);
    if (utilisateur_save == null)
    {
    	return new ResponseEntity<Utilisateur>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<Utilisateur>(utilisateur_save, HttpStatus.OK);
  }


  

  /**
   * Web service endpoint to fetch a single Utilisateur entity by primary key
   * identifier and send it as an email.
   *
   * If found, the Utilisateur is returned as JSON with HTTP status 200 and sent
   * via Email.
   *
   * If not found, the service returns an empty response body with HTTP status
   * 404.
   *
   * @param id A Long URL path variable containing the Utilisateur primary key
   *        identifier.
   * @param waitForAsyncResult A boolean indicating if the web service should
   *        wait for the asynchronous email transmission.
   * @return A ResponseEntity containing a single Utilisateur object, if found,
   *         and a HTTP status code as described in the method comment.
   */
  @CrossOrigin
  @RequestMapping(
          value = "/maps/utilisateur/{id}/send",
          method = RequestMethod.POST,
          produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Utilisateur> sendUtilisateur(@PathVariable("id") int id,
          @RequestParam(
                  value = "wait",
                  defaultValue = "false") boolean waitForAsyncResult) {

      logger.info("> sendUtilisateur id:{}", id);

      Utilisateur utilisateur = null;

      try {
          utilisateur = utilisateurService.findOne(id);
          if (utilisateur == null) {
              logger.info("< sendUtilisateur id:{}", id);
              return new ResponseEntity<Utilisateur>(HttpStatus.NOT_FOUND);
          }

          if (waitForAsyncResult) {
              Future<Boolean> asyncResponse = emailService
                      .sendAsyncWithResult(utilisateur);
              boolean emailSent = asyncResponse.get();
              logger.info("- utilisateur email sent? {}", emailSent);
          } else {
              emailService.sendAsync(utilisateur);
          }
      } catch (Exception e) {
          logger.error("A problem occurred sending the Utilisateur.", e);
          return new ResponseEntity<Utilisateur>(
                  HttpStatus.INTERNAL_SERVER_ERROR);
      }

      logger.info("< sendUtilisateur id:{}", id);
      return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
  }
}
