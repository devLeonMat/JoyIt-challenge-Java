package com.joyIt.rleon.challenge.TechnicalChallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TechnicalChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalChallengeApplication.class, args);
	}

}
