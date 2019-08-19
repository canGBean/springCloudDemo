package com.server.eureka.eureka0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka0Application {

	public static void main(String[] args) {
//		SpringApplication.run(Eureka0Application.class, args);
		new SpringApplicationBuilder(Eureka0Application.class).web(WebApplicationType.SERVLET).run(args);
	}

}
