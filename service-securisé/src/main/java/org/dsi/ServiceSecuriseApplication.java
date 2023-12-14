package org.dsi;


import java.util.ArrayList;
import java.util.List;

import org.dsi.entity.Album;
import org.dsi.entity.Photo;
import org.dsi.repo.AlbumRepo;
import org.dsi.service.feignservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ServiceSecuriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSecuriseApplication.class, args);
	}

	/*@Bean
	public CommandLineRunner start(AlbumRepo AlbumRepo , ) {
		
		System.out.println("ddddddddddddddddddddddddd"+album);
		return null;
	}*/
	
}
