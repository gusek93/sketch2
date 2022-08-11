package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.application.in.CreateEventUseCase;
import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.domain.OnlineEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEventService implements CreateEventUseCase {
    private final CreateEventOutPort creatEventOutputPort;
    @Override
    public void create(CreateEventRequest request) {
        creatEventOutputPort.create(new OnlineEvent(null,(long) request.getGoodsNo(), null,request.getEventEndAt(),request.getEventEndAt()));
    }
}
