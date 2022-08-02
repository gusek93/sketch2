package com.example.sketch2.event.application.port.out;

import com.example.sketch2.event.domain.OnlineEvent;

import java.util.List;

public interface CreateEventOutputPort {
    void create(OnlineEvent onlineEvent);

    void create(List<OnlineEvent> onlineEvents);
}
