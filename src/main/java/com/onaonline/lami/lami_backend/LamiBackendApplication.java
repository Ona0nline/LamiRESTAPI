package com.onaonline.lami.lami_backend;

import com.onaonline.lami.lami_backend.externalApis.osrm.OSRMService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.onaonline.lami.lami_backend.database.details")

public class LamiBackendApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LamiBackendApplication.class, args);
	}

}
