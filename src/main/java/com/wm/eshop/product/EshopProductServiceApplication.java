package com.wm.eshop.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// 将本应用作为一个微服务注册到Eureka Server上去
@EnableEurekaClient
public class EshopProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopProductServiceApplication.class, args);
	}

}
