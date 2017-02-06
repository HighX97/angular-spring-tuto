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
		resto.setWelcomeNote("welcomeNote restaunt 0");
		resto.greetCustomer();
		resto.prepareHotDrink();
		resto.displayWaitersNames();

		Restaurant resto1 =  (Restaurant) context.getBean("restaurantBean");
		resto1.greetCustomer();
		resto1.prepareHotDrink();
		resto1.displayWaitersNames();

		Restaurant resto2 =  (Restaurant) context.getBean("restaurantBeanSing");
		resto2.setWelcomeNote("welcomeNote restaunt 2");
		resto2.greetCustomer();
		resto2.prepareHotDrink();
		resto2.displayWaitersNames();

		Restaurant resto3 =  (Restaurant) context.getBean("restaurantBeanSing");
		resto3.greetCustomer();
		resto3.prepareHotDrink();
		resto3.displayWaitersNames();
	}

}
