package com.example.sketch2.application.service;

import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.domain.OnlineEvent;

import java.util.List;

public class CreateEventOutPortMock implements CreateEventOutPort {
    public OnlineEvent create_received_argument;
    public List<OnlineEvent> create_received_argument_list;

    @Override
    public void create(final OnlineEvent onlineEvent) {
        create_received_argument = onlineEvent;
    }

    @Override
    public void create(List<OnlineEvent> onlineEvents) {
        create_received_argument_list = onlineEvents;
    }
}