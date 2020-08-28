package com.goodbooks.bookcatalogue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.goodbooks.bookcatalogue")
public class BookcatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogueApplication.class, args);
	}

}
