package ar.edu.ciu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemoApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApiServerApplication.class, args);
	}

}
