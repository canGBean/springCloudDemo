package com.example.dubboconsumersample.controller;


import com.example.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboConsumerSampleController {

	@DubboReference
	private EchoService echoService;

	// http://127.0.0.1:8080/echo?message=somemessage
	@GetMapping("/echo")
	public String echo(@RequestParam(name = "message", defaultValue = "no message") String message) {
		return echoService.echo(message);
	}
}
