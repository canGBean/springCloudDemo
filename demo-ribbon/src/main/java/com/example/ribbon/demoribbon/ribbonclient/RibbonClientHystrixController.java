package com.example.ribbon.demoribbon.ribbonclient;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * ribbon client 带有熔断 测试
 */
@RestController
@Slf4j
@RequestMapping("/")
public class RibbonClientHystrixController {

	@Autowired
	RibbonHystrixService ribbonHystrixService;

	@RequestMapping(value = "client/get/{id}")
	public String hi(@PathVariable String id) {
		String randomString = this.ribbonHystrixService.hi(id);
		return "Server Response :: " + randomString + "---" +id;
	}


}
