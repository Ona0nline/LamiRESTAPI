package com.onaonline.lami.lami_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.onaonline.lami.lami_backend.database.details")

public class LamiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LamiBackendApplication.class, args);
	}

}
