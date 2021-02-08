package com.example.ribbon.demoribbonlb.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
@ExcludeComponent
//@Primary
public class RibbonCustomerBConfiguration {

	@Autowired
	IClientConfig config;

	/**
	 * 此配置开启后,如果自定义规则（继承AbstractLoadBalancerRule）后影响lb.getReachableServers()的值
	 * @param config
	 * @return
	 */
//	@Bean
//	public IPing ribbonPing(IClientConfig config) {
//		log.info("ribbo ping B config");
//		return new PingUrl();
//	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		log.info("ribbo rule B config");
		CustomerBRule rule = new CustomerBRule();
		return rule;
	}
}
