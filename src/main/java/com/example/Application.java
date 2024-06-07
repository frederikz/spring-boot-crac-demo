package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public SomeBean someBean() {
		return new SomeBean();
	}
	
	public static class SomeBean implements ApplicationListener<ContextRefreshedEvent> {
		
		@Override
	    public void onApplicationEvent(ContextRefreshedEvent event) {
			GenericApplicationContext applicationContext = new GenericApplicationContext();
			applicationContext.refresh();
	    }
	}
	
}