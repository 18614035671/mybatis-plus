package com.disp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.disp.dao")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Success!!!");
	}

}
