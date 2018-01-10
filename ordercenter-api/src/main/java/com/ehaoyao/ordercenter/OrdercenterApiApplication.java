package com.ehaoyao.ordercenter;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class OrdercenterApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OrdercenterApiApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
}
