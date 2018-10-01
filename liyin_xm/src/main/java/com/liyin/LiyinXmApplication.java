package com.liyin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liyin.mapper")
public class LiyinXmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiyinXmApplication.class, args);
	}
}
