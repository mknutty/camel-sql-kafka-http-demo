package mkn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CamelSqlDemoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(CamelSqlDemoApplication.class, args);
	}

}
