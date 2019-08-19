package com.server.eureka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerEurekaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ServerEurekaApplication.class, args);
		new SpringApplicationBuilder(ServerEurekaApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
