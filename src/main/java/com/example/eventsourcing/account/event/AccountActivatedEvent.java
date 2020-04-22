package com.example.eventsourcing.account.event;

import com.example.eventsourcing.account.aggregate.Status;

import lombok.ToString;

@ToString
public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
