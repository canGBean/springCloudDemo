package com.alibaba.cloud.nacosconfigsample;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

//@Configuration
@RefreshScope
@RestController
@EnableConfigurationProperties(User.class)
public class NacosConfigDemo {

	@Value("${user.name}")
	private String userName;

	@Value("${user.age}")
	private int userAge;

	@Value("${ext.config}")
	private int extConfig;

	@Autowired
	private User user;

	@Autowired
	private NacosConfigManager nacosConfigManager;

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			String dataId = "nacos-config-sample.properties";
			String group = "DEFAULT_GROUP";
			nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
				@Override
				public void receiveConfigInfo(String configInfo) {
					System.out.println("[Listener] " + configInfo);
					System.out.println("[Before] " + user);

					Properties properties = new Properties();
					try {
						properties.load(new StringReader(configInfo));
						String name = properties.getProperty("user.name");
						int age =  Integer.valueOf(properties.getProperty("user.age"));
						user.setName(name);
						user.setAge(age);
					}catch (IOException e){
						e.printStackTrace();
					}
					System.out.println("[After User] " + user);
				}
			});
		};
	}


	@PostConstruct
	public void init() {
		System.out.printf("[init] user name : %s , age : %d%n", userName, userAge);
		System.out.printf("[init] extConfig : %d%n", extConfig);
	}

	@PreDestroy
	public void destroy() {
		System.out.printf("[destroy] user name : %s , age : %d%n", userName, userAge);
		System.out.printf("[destroy] extConfig : %d%n", extConfig);
	}

	@RequestMapping("/user")
	public String user() {
		return String.format("[HTTP] user name : %s , age : %d", userName, userAge);
	}

	@RequestMapping("/userObject")
	public String userObject() {
		return "[HTTP] " + user;
	}


}
