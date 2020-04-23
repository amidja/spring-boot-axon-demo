package com.example.eventsourcing.account.services.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.eventsourcing.accout.services.command.AccountCommandService;
import com.example.eventsourcing.accout.services.query.AccountQueryService;

@Disabled //Not sure how to test the service layer!!!
@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TestConfig.class)
//@AutoConfigurationPackage
//@SpringBootConfiguration
@Configuration
//@ComponentScan({"com.example.eventsourcing.account.aggregate", "com.example.eventsourcing.account.services" })
@ComponentScan({"com.example.eventsourcing", "org.axonframework.eventsourcing" })
@DataJpaTest
@ActiveProfiles("prod")
class AccountCommandServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountCommandServiceTest.class);
	
	@Autowired
	private AccountQueryService accQueryService;

	@Autowired
	private AccountCommandService accCommandService;
	
	@Test
	void testPlumbing() {
		
		assertNotNull(accQueryService);
		assertNotNull(accCommandService);
	}

}

