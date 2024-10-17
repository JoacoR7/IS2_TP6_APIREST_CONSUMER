package com.is2.tp3_ej6_consumidor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class Tp3Ej6ApirestConsumidorApplication {
	
	@Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
		SpringApplication.run(Tp3Ej6ApirestConsumidorApplication.class, args);
	}

}
