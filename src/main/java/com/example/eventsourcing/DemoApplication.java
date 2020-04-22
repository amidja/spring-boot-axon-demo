package com.example.eventsourcing;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.example.eventsourcing.accout.services.command.AccountCommandService;
import com.example.eventsourcing.accout.services.command.dto.AccountCreateDTO;
import com.example.eventsourcing.accout.services.query.AccountQueryService;
import com.example.eventsourcing.config.SwaggerConfig;

@SpringBootApplication
@Import({ SwaggerConfig.class })
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	@Autowired
	private AccountQueryService accQueryService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// CommandLineRunner is an interface used to indicate that a bean should run
	// when it is contained within a SpringApplication
	@Bean
	public CommandLineRunner demo(AccountCommandService accCommandService) {
		return (args) ->{
			LOGGER.info("Starting Account Creation Demo");
			AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
			CompletableFuture<String> response = accCommandService.createAccount(accountCreateDTO);
			LOGGER.info("New Account Created, ID:{} ", response.get());
			List<Object> accountEvents = accQueryService.listEventsForAccount(response.get());
			
			accountEvents.stream().forEach(event -> {
				LOGGER.info("Account envent: {}", event.toString());
			});
		
		};
	}
}
