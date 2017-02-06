package com.ouwasav.spring.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ouwasav.*;

import com.ouwasav.spring.classes.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/test")
    public String test(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format(template, "Chat");
    }

	@RequestMapping("/restau")
	public Restaurant getRestaurant(
			@RequestParam(value ="name" ,defaultValue="Resto") String name)
	{
		Tea t = new Tea();
		Restaurant r = new Restaurant(t) ;
		r.prepareHotDrink();
		return r;
	}

    @RequestMapping("/list")
    public List<Restaurant> test1(@RequestParam(value="name", defaultValue="World") String name) {
        List<Restaurant> rslt = new ArrayList<Restaurant>();
        rslt.add(new Restaurant("A"));
        rslt.add(new Restaurant("B"));
        rslt.add(new Restaurant("C"));
        rslt.add(new Restaurant("D"));
        rslt.add(new Restaurant("E"));
    	return rslt;
    }

}
