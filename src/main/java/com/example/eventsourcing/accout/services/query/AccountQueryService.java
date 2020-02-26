package com.example.eventsourcing.accout.services.query;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
}
