package gamersFun.com.example.gamersFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@EnableAsync
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) // stop method from running if user not authorized
@EntityScan(basePackages = {"gamersFun.com.example.gamersFun.entity"})
@ControllerAdvice(basePackages = {"gamersFun.com.example.gamersFun.exception"} )
public class GamersFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamersFunApplication.class, args);
	}

}
