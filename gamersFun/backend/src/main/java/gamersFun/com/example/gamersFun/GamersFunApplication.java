package gamersFun.com.example.gamersFun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;



//exclude = {
//		DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class
//}

@SpringBootApplication
public class GamersFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamersFunApplication.class, args);
	}

}
