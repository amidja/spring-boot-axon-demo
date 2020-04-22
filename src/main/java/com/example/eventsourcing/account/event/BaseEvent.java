package com.example.eventsourcing.account.event;

import lombok.ToString;

@ToString
public class BaseEvent<T> {

    public final T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
