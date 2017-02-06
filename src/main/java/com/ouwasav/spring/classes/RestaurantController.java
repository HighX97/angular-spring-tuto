package com.ouwasav.spring.classes;


import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

	@RequestMapping("/restau")
	public Restaurant getRestaurant(
			@RequestParam(value ="name" ,defaultValue="Resto") String name)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
		return r;
	}
}
