package com.example.eventsourcing.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.eventsourcing.account.aggregate", "com.example.eventsourcing.account.services", })
public class TestConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestConfig.class);

	public TestConfig() {
		LOGGER.info("... starting, TestConfig");
	}
}
