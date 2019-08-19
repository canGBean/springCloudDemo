package com.example.hystrix.demohystrix;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableTurbine
public class DemoHystrixApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoHystrixApplication.class, args);
		new SpringApplicationBuilder(DemoHystrixApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
