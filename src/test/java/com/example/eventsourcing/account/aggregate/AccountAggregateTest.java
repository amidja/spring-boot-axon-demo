package com.example.eventsourcing.account.aggregate;

import java.util.UUID;

import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.example.eventsourcing.account.command.CreateAccountCommand;
import com.example.eventsourcing.account.command.CreditMoneyCommand;
import com.example.eventsourcing.account.event.AccountActivatedEvent;
import com.example.eventsourcing.account.event.AccountCreatedEvent;
import com.example.eventsourcing.account.event.MoneyCreditedEvent;

/**
 * Demonstrates how to test event sourcing with Axon 
 * @see https://www.novatec-gmbh.de/en/blog/testing-event-sourcing-applications/
 */
class AccountAggregateTest {

	private FixtureConfiguration fixture;

	@BeforeEach
	public void setUp() {
		fixture = new AggregateTestFixture(AccountAggregate.class);
	}

	@Disabled @Test
	void createAccount() {
		final UUID accId = UUID.randomUUID();
		final String currency = "AUD";
		
		fixture.given().when(new CreateAccountCommand(accId.toString(), 0.0, currency))
			.expectSuccessfulHandlerExecution()
			.expectEvents(new AccountCreatedEvent(accId.toString(), 0.0, currency), new AccountActivatedEvent(accId.toString(), Status.ACTIVATED))
		;
	}
	
	@Test 
	void depositMoney() {
		final UUID accId = UUID.randomUUID();
		final String currency = "AUD";
		
		fixture.given(new AccountCreatedEvent(accId.toString(), 0.0, currency), new AccountActivatedEvent(accId.toString(), Status.ACTIVATED))						
			.when(new CreditMoneyCommand(accId.toString(), 12.0, currency))
			.expectSuccessfulHandlerExecution()
			.expectEvents(new MoneyCreditedEvent(accId.toString(), 12.0, currency))			
			;				
	}
	
}
