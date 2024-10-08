package com.example.custom_annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CustomAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomAnnotationApplication.class, args);
	}

}
