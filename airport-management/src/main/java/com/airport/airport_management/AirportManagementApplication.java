package com.airport.airport_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication(scanBasePackages = "com.airport")
@EnableJpaRepositories(basePackages = "com.airport.repository")
@EntityScan("com.airport.model")
public class AirportManagementApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(AirportManagementApplication.class, args);
	}

}
