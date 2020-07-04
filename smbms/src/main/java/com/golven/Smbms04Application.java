package com.golven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.golven.mapper")
@SpringBootApplication
public class Smbms04Application {

	public static void main(String[] args) {
		SpringApplication.run(Smbms04Application.class, args);
	}

}
