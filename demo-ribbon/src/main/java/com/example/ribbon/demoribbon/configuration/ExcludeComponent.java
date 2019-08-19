package com.example.ribbon.demoribbon.configuration;

/**
 * The CustomConfiguration clas must be a @Configuration class, but take care that it is not in a
 * @ComponentScan for the main application context. Otherwise, it is shared by all the @RibbonClients . If you
 * use @ComponentScan (or @SpringBootApplication ), you need to take steps to avoid it being included (for
 * instance, you can put it in a separate, non-overlapping package or specify the packages to scan
 * explicitly in the @ComponentScan ).
 * 自定义注解屏蔽掉 SpringBoot的ComponentScan
 * 如果不采用此方法,可以将类放到不与启动类的同级及其子目录的位置
 */
public @interface ExcludeComponent {
}
