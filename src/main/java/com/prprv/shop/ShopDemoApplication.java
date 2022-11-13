package com.prprv.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.prprv.shop.mapper")
public class ShopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopDemoApplication.class, args);
	}

}
