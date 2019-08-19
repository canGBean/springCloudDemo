package com.example.feignserver.demoserver;

import com.example.feignserver.demoserver.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@SpringBootApplication
@Slf4j
@EnableEurekaClient
@RestController
public class DemoServerApplication  {

	@RequestMapping("/hello")
	public String home() {
		Person person = Person.builder().id(123L).name("firstTestPerson").createTime(new Date()).build();
		log.info("person is {}",person.toString());
		return person.toString();
	}

	@RequestMapping("/helloBean")
	public Person personBean() {
		Person person = Person.builder().id(789L).name("PersonBean").createTime(new Date()).build();
		//编译不同的日志java -jar运行来测试负载均衡效果
		log.info("person is {}",person.toString());
//		log.info("Second person is {}",person.toString());
		return person;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoServerApplication.class, args);
	}

}
