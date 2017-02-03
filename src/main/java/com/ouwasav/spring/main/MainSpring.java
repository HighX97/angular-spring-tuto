package com.ouwasav.spring.main;

import org.springframework.context.ApplicationContext ;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ouwasav.spring.classes.* ;

public class MainSpring {
	
	private static ApplicationContext context;

	public static void main(String [] args)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
		
		context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		
		Restaurant resto =  (Restaurant) context.getBean("restaurantBean");
		
		resto.greetCustomer();
		resto.prepareHotDrink();
	}

}
