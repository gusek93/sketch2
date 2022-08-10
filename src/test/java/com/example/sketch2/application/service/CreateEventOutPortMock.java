package com.example.sketch2.application.service;

import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.domain.OnlineEvent;

public class CreateEventOutPortMock implements CreateEventOutPort {
    public OnlineEvent create_received_argument;

    @Override
    public void create(final OnlineEvent onlineEvent) {
        create_received_argument = onlineEvent;
    }
}
