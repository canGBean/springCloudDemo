package com.example.ribbon.demoribbon.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;


@Slf4j
//@Configuration
@ExcludeComponent
public class RibbonCustomerAConfiguration {
	@Autowired
	IClientConfig config;

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		log.info("ribbo rule A config,{}",config.getNameSpace());
		return new RandomRule();
	}
}
