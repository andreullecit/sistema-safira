package com.br.safira.sistema.sistemasafira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.br.safira.sistema.sistemasafira.repository")
@SpringBootApplication
public class SistemaSafiraApplication{

	public static void main(String[] args) {
				SpringApplication.run(SistemaSafiraApplication.class, args);
	}

}
