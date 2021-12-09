package com.Eseurveys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.Eseurveys.config.FileStorageProperties;



@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class EseurveysBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EseurveysBackEndApplication.class, args);
	}

}
