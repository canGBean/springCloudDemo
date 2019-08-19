# springCloudNetflixEurekaDemo

修改注释后可以单独运行Standalone Mode

分别修application.yml的peer1 peer2配置后,打成jar包分别运行（Two Peer Aware Eureka Servers）


## Standalone Mode
application.yml
```
server:
  port: 9761


spring:
  freemarker:
    template-loader-path: classpath:/templates/
    prefer-file-system-access: false

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

```

## Two Peer Aware Eureka Servers-Peer1

application.yml peer1 setting
```
server:
  port: 9761

spring:
  profiles:
    active: peer1


eureka:
  instance:
    hostname: peer1
#    通过主机名解析 不走ip解析
    prefer-ip-address: false
  client:
    registerWithEureka: true
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://peer2:9762/eureka/
```

application.yml peer2 setting

```
server:
  port: 9762

spring:
  profiles:
    active: peer2


eureka:
  instance:
    hostname: peer2
#    通过主机名解析 不走ip解析
    prefer-ip-address: false
  client:
    registerWithEureka: true
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://peer1:9761/eureka/
      
```
hosts setting
```
127.0.0.1 peer1
127.0.0.1 peer2

```