package com.example.eventsourcing.account.event;

import com.example.eventsourcing.account.aggregate.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
