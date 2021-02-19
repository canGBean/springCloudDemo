package com.example.dubboprovidersample.service;

import com.example.dubbo.api.FooService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * demo dubbo sentinel
 */
@DubboService
public class FooServiceImpl implements FooService {
	@Override
	public String sayHello(String name) {
		return "Hello, " + name;
	}

	@Override
	public long getCurrentTime(boolean slow) {
		// Simulate slow invocations randomly.
		if (slow) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ignored) {
			}
		}
		return System.currentTimeMillis();
	}
}
