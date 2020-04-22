package com.example.eventsourcing.account.event;

import lombok.ToString;

@ToString
public class MoneyDebitedEvent extends BaseEvent<String> {

    public final double debitAmount;

    public final String currency;

    public MoneyDebitedEvent(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
