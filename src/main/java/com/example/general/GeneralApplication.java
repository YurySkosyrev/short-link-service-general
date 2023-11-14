package com.example.general;

import com.example.general.links.LinksService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GeneralApplication {

	private final LinksService linksService;

	public GeneralApplication(LinksService linksService) {
		this.linksService = linksService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GeneralApplication.class, args);
	}

	@GetMapping
	private int status() {
		linksService.randomPull();
		return Thread.activeCount();
	}
}
