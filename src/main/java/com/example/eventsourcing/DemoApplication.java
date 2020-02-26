package com.example.eventsourcing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.eventsourcing.config.SwaggerConfig;

@SpringBootApplication
@Import({
	SwaggerConfig.class
})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}