package com.bsc.camelrestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.bsc.camelrestproject.camel")
public class CamelRestProjectApplication {
	public static void main(String[] args) {
        SpringApplication.run(CamelRestProjectApplication.class, args);
    }
}
