# 基于Spring Cloud的微服务的应用模板
一、开发
===
1.1、配置开发环境(基于spring cloud config)
---
 1) 配置本地Host<br>
    10.3.32.121 cas.ehaoyao.com<br>
   #10.21.25.116 config-server<br>
    10.7.1.20 node1<br>
    10.7.1.21 node2<br>
    10.7.1.22 node3<br>
   #10.21.25.116 api-gateway<br>
 2) 设置本地的开发环境
  文件:C:\opt\settings\server.properties<br>
  添加:<br>
  env=DEV<br>
  
 2) 启动项目<br>
     
 3) 验证项目<br>
 访问http://node1:10000/,并查看Instances currently registered with Eureka中，当前应用是否已被注册。<br>
 比如： 当前项目名称，需要查看项目中的bootstrap.properties文件<br>
 spring.application.name=order-api<br>
 
 
1.2、配置开发环境(基于Apollo配置中心)
----

二、应用 
===
2.1、界面
---
项目名称:ordercenter-ui <br>
应用名称:order-web <br>
端口:8083

2.2、接口
---
项目名称:ordercenter-api  <br>
应用名称:order-api <br>
端口：8082