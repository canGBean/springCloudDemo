# springCloudNetflixHystrixDashboardDemo
spring cloud Netflix Hystrix Dashboard Demo

Hystrix Dashboard
client端需要在application.yml中增加配置
```
#open hystrix support
feign:
   hystrix:
     enabled: true

# hystrix dashboard stream
management:
  endpoints:
    web:
      exposure:
         include: hystrix.stream
```

在springboot的启动类上增加注解@EnableCircuitBreaker

单节点访问监控：
Single Hystrix App: https://hystrix-app:port/actuator/hystrix.stream
参考中springCloudNetflixFeignClinetDemo中例子：
* springCloudNetflixEurekaDemo
* springCloudNetflixFeignServerDemo
* springCloudNetflixFeignClinetDemo


application.yml文件中增加turbine配置（默认名称及指定集群名称配置）
默认名称配置：
```
turbine:
  aggregator:
     cluster-config: default
  app-config: HelloClient,HelloClient1
  cluster-name-expression: "'default'"
```
指定名称配置：
```
turbine:
  aggregator:
    cluster-config: cluster
  app-config: HelloClient,HelloClient1
  cluster-name-expression: "'cluster'"
```
turbine.clusterNameExpression ：
* clusterNameExpressionclusterNameExpression指定集群名称，默认表达式appName；此时：turbine.aggregator.clusterConfig需要配置想要监控的应用名称；
* 当clusterNameExpression: default时，turbine.aggregator.clusterConfig可以不写，因为默认就是default；
* 当clusterNameExpression: metadata[‘cluster’]时，假设想要监控的应用配置了eureka.instance.metadata-map.cluster: ABC，则需要配置，同时turbine.aggregator.clusterConfig: ABC

参考链接[spring-cloud-netflix 的Reference Doc 5.2章节](https://cloud.spring.io/spring-cloud-static/spring-cloud-netflix/2.1.2.RELEASE/single/spring-cloud-netflix.html#_turbine)