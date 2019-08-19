package com.example.zuul.demozuul;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
@EnableEurekaClient
public class DemoZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoZuulApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
