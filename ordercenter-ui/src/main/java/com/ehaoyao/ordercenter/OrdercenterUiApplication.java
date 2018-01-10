package com.ehaoyao.ordercenter;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.ehaoyao.ordercenter.common.properties.JeeSiteProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableApolloConfig
@EnableConfigurationProperties(JeeSiteProperties.class)
@MapperScan(basePackages = {"com.thinkgem.jeesite.modules.sys.dao","com.ehaoyao.ordercenter.web.*.mappper"})
@SpringBootApplication(scanBasePackages = {"com.thinkgem.jeesite","com.ehaoyao.ordercenter"})
public class OrdercenterUiApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OrdercenterUiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OrdercenterUiApplication.class, args);
	}
}
