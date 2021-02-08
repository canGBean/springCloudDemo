package com.example.ribbon.demoribbonlb.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@ExcludeComponent
//@Primary
public class RibbonCustomerAConfiguration {

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		log.info("ribbo rule A config");
		return new RandomRule();
	}
}
