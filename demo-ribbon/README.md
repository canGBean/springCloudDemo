# springCloudNetflixRibbonDemo
ribbon client demo
通过java方式配置Ribbon的自定义负载策略（也可以根据配置文件）。其中根据文档中说明：
>The CustomConfiguration clas must be a @Configuration class, but take care that it is not in a
@ComponentScan for the main application context. Otherwise, it is shared by all the @RibbonClients . If you
use @ComponentScan (or @SpringBootApplication ), you need to take steps to avoid it being included (for
instance, you can put it in a separate, non-overlapping package or specify the packages to scan
explicitly in the @ComponentScan ).

自定义注解@ExcludeComponent，同时在启动类上配置不扫描使用该注解的类
```
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
  		value = {com.example.ribbon.demoribbon.configuration.ExcludeComponent.class})})
```
SpringBoot的ComponentScan如果不采用此方法,可以将类放到不与启动类的同级及其子目录的位置。

此客户端采用的是使用Eureka的方式进行注册

在@RibbonClients配置中，如果使用了defaultConfiguration的配置，那么其他@RibbonClient会全部走默认的负载策略，定制自定义注解时不能开启defaultConfiguration的配置。
