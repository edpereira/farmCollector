package com.eduardo.farmcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FarmcollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmcollectorApplication.class, args);
	}

}
