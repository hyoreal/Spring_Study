package org.study.springstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringstudyApplication.class, args);
	}

}
