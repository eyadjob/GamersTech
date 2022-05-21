package com.gamerfunthymeleaf.gamersFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@SpringBootApplication
@EnableJpaRepositories("com.gamerfunthymeleaf.gamersFun.repository")
public class GamerfunthymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamerfunthymeleafApplication.class, args);
	}

}
