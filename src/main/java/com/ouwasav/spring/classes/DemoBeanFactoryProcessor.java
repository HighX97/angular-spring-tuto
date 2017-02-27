package com.ouwasav.spring.classes;

import org.omg.CORBA.ARG_OUT;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DemoBeanFactoryProcessor implements BeanFactoryPostProcessor{

	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub

		BeanDefinition beanDefinintion = arg0.getBeanDefinition("restaurantBean") ;
		MutablePropertyValues propertyValues =  beanDefinintion.getPropertyValues();

		propertyValues.addPropertyValue("welcomeNote", "This is the modified welcomeNote value using BeanFactoryPostProcessor ");

		BeanDefinition beanDefinintion1 = arg0.getBeanDefinition("restaurantBeanSing") ;
		MutablePropertyValues propertyValues1 =  beanDefinintion1.getPropertyValues();

		propertyValues1.addPropertyValue("welcomeNote", "This is the modified welcomeNote value using BeanFactoryPostProcessor ");


		BeanDefinition beanDefinintion2 = arg0.getBeanDefinition("restaurantBeanSingLazy") ;
		MutablePropertyValues propertyValues2 =  beanDefinintion2.getPropertyValues();

		propertyValues2.addPropertyValue("welcomeNote", "This is the modified welcomeNote value using BeanFactoryPostProcessor ");

	}

}
