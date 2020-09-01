package com.goodbooks.bookcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ConfigurationPropertiesScan("com.goodbooks.bookcatalogue")
@EnableEurekaClient
public class BookcatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogueApplication.class, args);
	}

}
