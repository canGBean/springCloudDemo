package com.example.feignclient.democlient.feign;


import com.example.feignclient.democlient.feign.hystrix.PersonServiceHystrix;
import com.example.feignclient.democlient.person.Person;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;



@FeignClient(value = "HELLOSERVER",fallback = PersonServiceHystrix.class)
//@RibbonClient("HELLOSERVER")
public interface PersonService {

	@RequestMapping("/hello")
	String getPerson();

	@RequestMapping("/helloBean")
	Person getPersonBean();
}
