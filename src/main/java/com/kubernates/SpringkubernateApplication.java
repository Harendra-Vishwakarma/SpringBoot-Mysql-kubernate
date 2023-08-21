package com.kubernates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kubernates")
public class SpringkubernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringkubernateApplication.class, args);
	}

}
