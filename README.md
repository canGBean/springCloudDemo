# springCloudDemo
## Netfilx demo
* Eureka two peers 的模式部署Demo
* feign client and server with hystrix
* ribbon demo
* hystrix-dashboard demo
* zuul demo
## Spring Cloud Alibaba demo
* demo-springcloud-alibaba

## Contents
### Eureka例子
项目demo-eureka01与eureka0,同时配置了双节点的例子

### feign例子
项目feign-demo-client 与feign-demo-server分别模拟了feign的Server端与client端，且分别注册到eurka上
feign例子中加入了hystrix的熔断测试、多个server时的负载均衡测试

### hystrix例子
项目demo-hystrix，主要测试hystrix的dashboard功能

### ribbon例子
项目demo-ribbon中，模拟了ribbon client与ribbon clients的方式，同时加入了hystrix的熔断测试
同时，增加了自定义路由策略的（JAVA配置）的例子

### zuul例子
zuul的网关路由测试

### SpringCloudAlibaba例子
主要demo来源与阿里云知行动手实验室上的demo
#### provider和client
provider和client包中的例子为“SpringCloudAlibaba体验-微服务开发入门教学”的demo,主要是服务提供者和消费者的基础调用
#### nacos-config-sample
nacos-config-sample是“通过 Nacos Config 实现分布式配置”的例子，主要介绍的是nacos的配置中心的基础使用
#### nacos-discovery-provider-sample和nacos-discovery-consumer-sample
这两个包里的demo主要是“使用 Nacos Discovery 进行服务注册/发现”的例子，介绍服务提供者和消费者的基础调用，内容和“provider和client”里的差不多

####  dubbo-providerr-sample和dubbo-consumer-sample
dubbo-providerr-sample和dubbo-consumer-sample包中的例子为"Spring Cloud Alibaba Sentinel 服务限流/熔断实战"和"分布式调用"的demo,主要是sentinel和dubbo的基本配置和使用.