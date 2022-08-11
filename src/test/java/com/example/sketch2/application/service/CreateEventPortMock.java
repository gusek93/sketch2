package com.example.sketch2.application.service;

import com.example.sketch2.application.out.CreateEventPort;
import com.example.sketch2.domain.OnlineEvent;

import java.util.List;

public class CreateEventPortMock implements CreateEventPort {
    public OnlineEvent create_received_argument;
    public List<OnlineEvent> create_received_argument_list;
    public boolean create_called;

    @Override
    public void create(final OnlineEvent onlineEvent) {
        create_received_argument = onlineEvent;
    }

    @Override
    public void create(List<OnlineEvent> onlineEvents) {
        create_called = true;
        create_received_argument_list = onlineEvents;
    }
}