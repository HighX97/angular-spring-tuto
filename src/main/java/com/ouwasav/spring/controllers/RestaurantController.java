package com.ouwasav.spring.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ouwasav.spring.models.Restaurant;
import com.ouwasav.spring.models.Tea;

@RestController
public class RestaurantController 
{
	
    List<Restaurant> rslt;
    public RestaurantController()
    {
    	rslt = new ArrayList<Restaurant>();
        rslt.add(new Restaurant("A"));
        rslt.add(new Restaurant("B"));
        rslt.add(new Restaurant("C"));
        rslt.add(new Restaurant("D"));
        rslt.add(new Restaurant("E"));
    }
	
	@RequestMapping(value = "/restau" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurant(
			@RequestParam(value ="name" ,defaultValue="Resto") String name)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
		return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/restau/{id}" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Restaurant> getRestaurantById(
			@PathVariable("id") int id )
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.setName("Restaurant"+id);
		r.prepareHotDrink();
		return new ResponseEntity<Restaurant>(r, HttpStatus.OK);
	}

    @RequestMapping(value = "/restau/list" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getAllRestaurant(@RequestParam(value="name", defaultValue="World") String name) {
    	return new ResponseEntity<List<Restaurant>>(rslt, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/restau" , method=RequestMethod.POST , consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE ,produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> createRestaurant(@RequestBody Restaurant resto) 
    {
    	System.err.println(resto);
    	this.rslt.add(resto);
    	return new ResponseEntity<List<Restaurant>>(this.rslt, HttpStatus.CREATED);
    }

}
