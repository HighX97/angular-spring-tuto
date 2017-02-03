package com.ouwasav.spring.classes;

public class Restaurant {
	
	//Tea tea = new Tea() ;
	IHotDrink hotDrink ;
	
	public Restaurant(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	public void prepareHotDrink() {
		//tea.prepareTea();
		hotDrink.prepareTea();
	}

}
