package com.example.ribbon.demoribbonlb;

import com.example.ribbon.demoribbonlb.configuration.RibbonCustomerAConfiguration;
import com.example.ribbon.demoribbonlb.configuration.RibbonCustomerBConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
		value = {com.example.ribbon.demoribbonlb.configuration.ExcludeComponent.class})})
@RibbonClients(
		value = {
//				@RibbonClient(name = "HELLOCLIENT", configuration = RibbonCustomerAConfiguration.class)
//				,
				@RibbonClient(name = "HELLOCLIENT", configuration = RibbonCustomerBConfiguration.class)
		}
)
public class DemoRibbonlbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRibbonlbApplication.class, args);
	}

}
