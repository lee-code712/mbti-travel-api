package com.travelcreation.mbti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MbtiTravelCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbtiTravelCompanyApplication.class, args);
	}

}
