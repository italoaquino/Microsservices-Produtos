package com.config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApplication implements CommandLineRunner {

	@Value("${spring.cloud.config.server.git.username}")
	private String username;

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
