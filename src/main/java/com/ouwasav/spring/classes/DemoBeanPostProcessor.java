package com.ouwasav.spring.classes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DemoBeanPostProcessor implements BeanPostProcessor
{

	
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.err.println("postProcessAfterInitialization (i.e just after init life cycle event ) of : " + arg1);
		return arg0;
	}

	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		// TODO Auto-generated method stub
		System.err.println("postProcessBeforeInitialization (i.e just after instanciante and before init life cycle event )" + arg1);
		return arg0;
	}

}
