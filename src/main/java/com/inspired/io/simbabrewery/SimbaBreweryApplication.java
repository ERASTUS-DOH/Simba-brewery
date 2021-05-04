package com.inspired.io.simbabrewery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class  SimbaBreweryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimbaBreweryApplication.class, args);

	}

}
