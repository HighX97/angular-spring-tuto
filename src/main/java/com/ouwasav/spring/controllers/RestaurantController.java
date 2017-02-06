package com.ouwasav.spring.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ouwasav.spring.models.Restaurant;
import com.ouwasav.spring.models.Tea;

@RestController
public class RestaurantController {
	
	@RequestMapping(value = "/restau" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Restaurant getRestaurant(
			@RequestParam(value ="name" ,defaultValue="Resto") String name)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
		return r;
	}

    @RequestMapping(value = "/list" , method=RequestMethod.GET , produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> test1(@RequestParam(value="name", defaultValue="World") String name) {
        List<Restaurant> rslt = new ArrayList<Restaurant>();
        rslt.add(new Restaurant("A"));
        rslt.add(new Restaurant("B"));
        rslt.add(new Restaurant("C"));
        rslt.add(new Restaurant("D"));
        rslt.add(new Restaurant("E"));
    	return rslt;
    }

}
