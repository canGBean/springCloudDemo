package com.example.ribbon.demoribbon;

import com.example.ribbon.demoribbon.configuration.RibbonCustomerAConfiguration;
import com.example.ribbon.demoribbon.configuration.RibbonCustomerBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import com.example.ribbon.demoribbon.configuration.RibbonDefaultConfiguration;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
		value = {com.example.ribbon.demoribbon.configuration.ExcludeComponent.class})})
//@RibbonClients(
//		value = {
//				@RibbonClient(name = "HELLOSERVER", configuration = RibbonCustomerAConfiguration.class),
//				@RibbonClient(name = "HELLOSERVER1", configuration = RibbonCustomerBConfiguration.class)
//		}
//		,
//		defaultConfiguration = RibbonDefaultConfiguration.class
//)
@RibbonClient(name = "HELLOSERVER", configuration = RibbonCustomerBConfiguration.class)
@EnableCircuitBreaker
public class DemoRibbonApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoRibbonApplication.class, args);
	}

}
