package com.KartikeySingh.project.UberApp.Uber_Cl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.KartikeySingh.project.UberApp.Uber_Cl.repositories")
@EntityScan(basePackages = "com.KartikeySingh.project.UberApp.Uber_Cl.entities")
public class UberClApplication {
	public static void main(String[] args) {
		SpringApplication.run(UberClApplication.class, args);
	}
}

