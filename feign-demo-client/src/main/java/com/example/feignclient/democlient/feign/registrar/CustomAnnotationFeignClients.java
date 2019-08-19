package com.example.feignclient.democlient.feign.registrar;


import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

/**
 * 测试自定义的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(FeignCustomRegistrar.class)
public @interface CustomAnnotationFeignClients {

	String[] value() default {};
	String[] basePackages() default {};
	Class<?>[] basePackageClasses() default {};
	Class<?>[] defaultConfiguration() default {};
	Class<?>[] clients() default {};

}
