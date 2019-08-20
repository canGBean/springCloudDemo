package com.example.feignclient.democlient;

import com.example.feignclient.democlient.feign.PersonService;
import com.example.feignclient.democlient.person.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@RestController
@Slf4j
//@CustomAnnotationFeignClients

@EnableCircuitBreaker
public class DemoClientApplication {

	@Autowired
	PersonService personService;

	@RequestMapping("/person/getbean")
	public String queryPersonBean() {
		Person person = personService.getPersonBean();
		person.setUpdateTime(new Date());
		log.info("client query person is {}",person.toString());
		return person.toString();
	}

	@RequestMapping("/person/get")
	public String queryPerson() {
		String person = personService.getPerson();
		log.info("client query person is {}",person);
		return person;
	}


	@RequestMapping("/person/getwithheader")
	public String queryPersonSetHeader(HttpServletRequest request, HttpServletResponse response){
		String person = personService.getPerson();
		response.setHeader("referer","bbb");
		response.setHeader("appId","bbb");
		log.info("client query person is {}",person);
		return person;

	}
//	@Component
//	public class StoreIntegration {
//		@HystrixCommand(fallbackMethod = "defaultStores")
//		public Object getStores(Map<String, Object> parameters) {
//			return new Date();
//		}
//
//		public Object defaultStores(Map<String, Object> parameters) {
//			return  "123";
//		}
//	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoClientApplication.class).web(WebApplicationType.SERVLET).run(args);
//		SpringApplication.run(DemoClientApplication.class, args);
	}

}
