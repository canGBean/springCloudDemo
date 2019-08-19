# springCloudNetflixFeignClinetDemo
spring cloud netflix feign clinet demo

application.yml中增加熔断及hystrix的dashboard支持
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
