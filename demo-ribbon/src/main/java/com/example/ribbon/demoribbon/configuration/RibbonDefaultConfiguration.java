package com.example.ribbon.demoribbon.configuration;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
//@Configuration
@ExcludeComponent
public class RibbonDefaultConfiguration {

	@Autowired
	IClientConfig config;

	@Bean
	public IRule ribbonRule() {
		log.info("ribbo rule default RoundRobinRule");
//		return new AvailabilityFilteringRule();
		log.info(config.getNameSpace());
		return new RoundRobinRule();
	}
}
