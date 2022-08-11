package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.application.in.CreateEventUseCase;
import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.application.out.LoadEventGoodsOrderOutPort;
import com.example.sketch2.domain.EventGoodsOrder;
import com.example.sketch2.domain.OnlineEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateEventService implements CreateEventUseCase {
    private final LoadEventGoodsOrderOutPort loadEventGoodsOrderOutPort;
    private final CreateEventOutPort creatEventOutPort;

    @Override
    public void create(final CreateEventRequest request) {
        final List<EventGoodsOrder> orders = loadEventGoodsOrderOutPort.loadOrders();
        List<OnlineEvent> onlineEventList = new ArrayList<>();
        for (final EventGoodsOrder order : orders) {
            final OnlineEvent event = createEvent(request, order);
            onlineEventList.add(event);
        }
        creatEventOutPort.create(onlineEventList);
    }

    private OnlineEvent createEvent(final CreateEventRequest request, final EventGoodsOrder order) {
        return new OnlineEvent(
                order.getOrderNo(),
                request.getGoodsNo(),
                order.getOrderUserNo(),
                request.getEventEndAt(),
                request.getEventEndAt()
        );
    }
}
