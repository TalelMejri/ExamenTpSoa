package org.dsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class ClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);
	}
	
	 @Bean
	 public RestTemplate getRestTemplate() {
	    	return new RestTemplate();
	 }

}
