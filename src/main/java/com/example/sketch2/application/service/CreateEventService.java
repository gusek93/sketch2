package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.application.in.CreateEventUseCase;
import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.application.out.LoadEventGoodsOrderOutPort;
import com.example.sketch2.domain.OnlineEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateEventService implements CreateEventUseCase {
    private final LoadEventGoodsOrderOutPort loadEventGoodsOrderOutPort;
    private final CreateEventOutPort creatEventOutPort;

    @Override
    public void create(final CreateEventRequest request) {
        creatEventOutPort.create(List.of(createOnlineEvent(request)));
    }

    private OnlineEvent createOnlineEvent(CreateEventRequest request) {
        return new OnlineEvent(null, request.getGoodsNo(), null, request.getEventEndAt(), request.getEventEndAt());
    }
}
