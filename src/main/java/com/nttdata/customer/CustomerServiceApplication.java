package com.nttdata.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
		/*SpringApplication app = new SpringApplication(CustomerServiceApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8091"));
		app.run(args);*/
	}

}
