package com.ouwasav.spring.classes;

import java.util.List;

public class Restaurant {
	
	//Tea tea = new Tea() ;
	IHotDrink hotDrink ;
	private String welcomeNote ;
	private List<String> restaurantWaitersList ;
	
	
	public void greetCustomer(){
		System.out.println(welcomeNote);
	}
	
	public Restaurant() {
	}
	
	public Restaurant(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	public void setHotDrink(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	public void prepareHotDrink() {
		//tea.prepareTea();
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

}
