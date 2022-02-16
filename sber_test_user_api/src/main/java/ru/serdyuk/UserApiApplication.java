package ru.serdyuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new  SpringApplication(UserApiApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
	}

}
