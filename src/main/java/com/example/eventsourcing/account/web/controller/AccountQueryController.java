package com.example.eventsourcing.account.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventsourcing.accout.services.query.AccountQueryService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {

	private final AccountQueryService accountQueryService;

	public AccountQueryController(AccountQueryService accountQueryService) {
		this.accountQueryService = accountQueryService;
	}

	@GetMapping("/{accountNumber}/events")
	public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber) {
		return accountQueryService.listEventsForAccount(accountNumber);
	}
}
