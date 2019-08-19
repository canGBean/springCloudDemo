package com.example.feignclient.democlient.feign.hystrix;

import com.example.feignclient.democlient.feign.PersonService;
import com.example.feignclient.democlient.person.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceHystrix implements PersonService {

	@Override
	public String getPerson() {
		return  "hello get person str, this messge send failed ";
	}

	@Override
	public Person getPersonBean() {
		return Person.builder().id(0L).name("hello get bean str, this messge send failed").build();
	}
}
