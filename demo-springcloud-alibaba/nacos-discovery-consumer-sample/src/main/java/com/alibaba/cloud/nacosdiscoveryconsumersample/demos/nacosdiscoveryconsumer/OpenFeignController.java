package com.alibaba.cloud.nacosdiscoveryconsumersample.demos.nacosdiscoveryconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenFeignController {

	@Autowired
	private EchoService echoService;

	@GetMapping("/feign/echo/{message}")
	public String feignEcho(@PathVariable String message) {
		System.out.println(message);
		return echoService.echo(message);
	}
}
