package com.example.ribbon.demoribbon.ribbonclient;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RibbonHystrixService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiFallBack")
	public String hi(String id){
		return this.restTemplate.getForObject("http://HELLOSERVER/hello", String.class);
	}

	private String hiFallBack(String id){
		return "hello get person str, this messge send failed "+id;
	}
}
