# springCloudNetflixZuulDemo

application.yml中添加zuul配置如下
```
# 访问http://127.0.0.1:9861/myperson/person/getbean来访问client
# 自动匹配eureka中注册的serviceid
# 如果注释掉自定义的匹配(以下配置均注释掉，则会使用默认配置)，访问http://127.0.0.1:9861/serviceid/person/getbean请求会被转发到对应的serviceid的服务上
zuul:
  routes:
    users:
      path: /myperson/**
      serviceId: HelloClient
```
