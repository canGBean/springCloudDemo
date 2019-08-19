package com.example.feignclient.democlient.feign.registrar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 测试自定义的注解
 */
@Slf4j
public class FeignCustomRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {
	@Override
	public void setEnvironment(Environment environment) {
		log.info("init environment");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		log.info("init resource");

	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		log.info("init registerBean");
	}
}



