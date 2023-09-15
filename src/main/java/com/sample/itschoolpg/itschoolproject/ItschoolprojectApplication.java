package com.sample.itschoolpg.itschoolproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan	("com.sample.itschoolpg.itschoolproject.mapper")
@SpringBootApplication
public class ItschoolprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItschoolprojectApplication.class, args);
	}

}
