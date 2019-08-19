package com.example.ribbon.demoribbon.ribbonclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/")
public class RibbonClientSideController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@RequestMapping(value = "client/frontend/{id}")
	public String hi(@PathVariable String id) {
		log.info(id);
//		ServiceInstance serviceInstance = loadBalancerClient.choose("HELLOSERVER");
		String randomString = this.restTemplate.getForObject("http://HELLOSERVER/hello", String.class);
		return "Server Response :: " + randomString + "---" +id;
	}

	@RequestMapping(value = "client/frontend1/{id}")
	public String hi1(@PathVariable String id) {
		log.info(id);
//		ServiceInstance serviceInstance = loadBalancerClient.choose("HELLOSERVER1");
		String randomString = this.restTemplate.getForObject("http://HELLOSERVER1/hello", String.class);
		return "Server Response :: " + randomString + "---" +id;
	}
}
