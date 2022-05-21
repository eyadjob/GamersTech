package com.appress.ravi.userRegistrationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
public class UserRegistrationSystemApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  SpringApplication.run(UserRegistrationSystemApplication.class, args);
		String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);

		for (String name : beans) {
			System.out.println(name);
		}

	}

}
