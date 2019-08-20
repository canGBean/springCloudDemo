# springCloudNetflixDemo
Netfilx demo
* Eureka two peers 的模式部署Demo
* feign client and server with hystrix
* ribbon demo
* hystrix-dashboard demo
* zuul demo

#### Eureka例子
项目demo-eureka01与eureka0,同时配置了双节点的例子

#### feign例子
项目feign-demo-client 与feign-demo-server分别模拟了feign的Server端与client端，且分别注册到eurka上
feign例子中加入了hystrix的熔断测试、多个server时的负载均衡测试

#### hystrix例子
项目demo-hystrix，主要测试hystrix的dashboard功能

#### ribbon例子
项目demo-ribbon中，模拟了ribbon client与ribbon clients的方式，同时加入了hystrix的熔断测试
同时，增加了自定义路由策略的（JAVA配置）的例子

#### zuul例子
zuul的网关路由测试
