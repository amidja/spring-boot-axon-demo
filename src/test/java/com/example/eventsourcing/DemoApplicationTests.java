package com.example.eventsourcing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.StringUtils;

import com.example.eventsourcing.accout.services.command.AccountCommandService;
import com.example.eventsourcing.accout.services.command.dto.AccountCreateDTO;
import com.example.eventsourcing.accout.services.query.AccountQueryService;


@Disabled
@SpringBootTest
@ActiveProfiles("prod")
class DemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplicationTests.class);
	
	@Autowired(required=true)
	private AccountQueryService accQueryService;

	@Autowired(required=true)
	private AccountCommandService accCommandService;
	
	@Test
	void contextLoads() {
		LOGGER.info("Stating contextLoadsTest .... ");		
	}

	
	@Test
	void appDemo() throws InterruptedException, ExecutionException {
		LOGGER.info("Stating appDemo .... ");	
		
		LOGGER.info("Starting Account Creation Demo");
		AccountCreateDTO accountCreateDTO = new AccountCreateDTO();
		CompletableFuture<String> response = accCommandService.createAccount(accountCreateDTO);
		LOGGER.info("New Account Created, ID:{} ", response.get());
		List<Object> accountEvents = accQueryService.listEventsForAccount(response.get());
		assertTrue(!StringUtils.isEmpty(response.get()));
		
		accountEvents.stream().forEach(event -> {
			LOGGER.info("Account envent: {}", event.toString());
		});

	}
}