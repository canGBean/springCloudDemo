package com.example.zuul.demozuul;

import com.example.zuul.demozuul.filter.CsrfFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
@EnableEurekaClient
public class DemoZuulApplication {

	@Bean
	public CsrfFilter csrfFilter(){
		return new CsrfFilter();
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoZuulApplication.class).web(WebApplicationType.SERVLET).run(args);
	}

}
