package com.example.dubboprovidersample.service;


import com.example.dubbo.api.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * demo dubbo
 */
@DubboService
public class SimpleEchoService implements EchoService {

	@Override
	public String echo(String message) {
		return "[ECHO] " + message;
	}
}
