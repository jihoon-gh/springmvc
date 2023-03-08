package hello.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class SpringmvcApplication {
	//sl4j = 인터페이스, logback = sl4j 구현체
	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);



	}
}
