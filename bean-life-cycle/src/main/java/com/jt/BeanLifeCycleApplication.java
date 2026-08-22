package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(BeanLifeCycleApplication.class, args);
		var greet = context.getBean(Greet.class);
		greet.greet();
	}

	/*
		BEAN LIFE CYCLE
		1. Bean Instansiated - Object is vreated - constructor
		2. Dependency Injected(if availa ble)    - by using any way of Di
		3. Bean Initialized 					 - @PostConstruct
		4. Bean Used
		5. Bean Destroyed  						 - @PreDestroy

		-Managed By Spring Container
	*/
}
