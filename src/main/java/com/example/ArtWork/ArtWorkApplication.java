package com.example.ArtWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Repository") 
public class ArtWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtWorkApplication.class, args);
	}
	@RestController
	public class TestController {

	    // A simple GET endpoint for testing
	    @GetMapping("/test1")
	    public String testEndpoint() {
	        return "Hello from ArtWork Application!";
	    }
	}

}
