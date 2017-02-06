package com.ouwasav.spring.classes;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Restaurant {
	
	private static int count = 0; ;
	//Tea tea = new Tea() ;
	IHotDrink hotDrink ;
	private String welcomeNote ;
	private int id ;
	
	private List<String> restaurantWaitersList ;
	
	
	public void greetCustomer(){
		System.out.println(welcomeNote);
	}
	
	public Restaurant() {
		this.setId(++count) ;;
	}
	
	public Restaurant(IHotDrink hotDrink) {
		this();
		this.hotDrink = hotDrink;
	}
	
	public void setHotDrink(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	public void prepareHotDrink() {
		hotDrink.prepareHotDrink();
	}

	public String getWelcomeNote() {
		return welcomeNote;
	}

	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}

	public List<String> getRestaurantWaitersList() {
		return restaurantWaitersList;
	}
	
	public void displayWaitersNames()
	{
		int i = 0 ;
		for (String waiter : restaurantWaitersList)
		{
			System.out.println(++i+" : " + waiter);
		}
	}

	public void setRestaurantWaitersList(List<String> restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}
	
	@PostConstruct
	public void init()
	{
		System.err.println("Restaurant Bean"+this.id+" is going through init.");
	}
	
	@PreDestroy
	public void destroy()
	{
		System.err.println("Restaurant Bean"+this.id+" will be destroy now.");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
