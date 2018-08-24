package com.jonathanperez.perspective;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class PerspectiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerspectiveApplication.class, args);
	}
}
