package com.ouwasav.restService;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ouwasav.*;
import com.ouwasav.spring.classes.Restaurant;
import com.ouwasav.spring.classes.Tea;

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
}
