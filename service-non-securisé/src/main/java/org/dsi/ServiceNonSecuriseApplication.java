package org.dsi;

import org.dsi.entity.PhotoEntity;
import org.dsi.repo.photoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceNonSecuriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceNonSecuriseApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(photoRepo photorepo)
	{
		return args->{
			photorepo.save(new PhotoEntity(null,"12-15-2002","10-5-2002"));
			photorepo.save(new PhotoEntity(null,"13-05-2002","19-05-2003"));
			photorepo.save(new PhotoEntity(null,"19-09-2002","25-08-2006"));
			photorepo.findAll().forEach(System.out::println);
		};
	}

}
