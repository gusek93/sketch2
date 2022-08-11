package com.example.sketch2.application.out;

import com.example.sketch2.domain.OnlineEvent;

import java.util.List;

public interface CreateEventPort {
    void create(OnlineEvent onlineEvent);

    void create(List<OnlineEvent> onlineEvents);
}
