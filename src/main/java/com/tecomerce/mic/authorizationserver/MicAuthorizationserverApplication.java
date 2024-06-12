package com.tecomerce.mic.authorizationserver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(servers = {
//		@Server(url = "https://mic-authorizationserver-production.up.railway.app/")
//})
public class MicAuthorizationserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicAuthorizationserverApplication.class, args);
	}
}
