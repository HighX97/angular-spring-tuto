package com.ouwasav.spring.main;

import com.ouwasav.spring.classes.* ;

public class MainSpring {
	
	public static void main(String [] args)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
	}

}
