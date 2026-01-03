package com.nesa.hostpitaldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HostpitaldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostpitaldemoApplication.class, args);
	}

}

@RestController
class CommonController {
	@GetMapping("/ping")
	String ping() {
		return "pong";
	}
}
