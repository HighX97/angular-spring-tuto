package com.ouwasav.spring.classes;

public class Restaurant {
	
	//Tea tea = new Tea() ;
	IHotDrink hotDrink ;
	private String welcomeNote ;
	
	
	public void greetCustomer(){
		System.out.println(welcomeNote);
	}
	
	public Restaurant() {
	}
	
	public Restaurant(IHotDrink hotDrink) {
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

}
