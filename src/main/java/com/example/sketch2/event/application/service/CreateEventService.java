package com.example.sketch2.event.application.service;

import com.example.sketch2.event.application.port.in.CreateEventRequest;
import com.example.sketch2.event.application.port.in.CreateEventUseCase;
import com.example.sketch2.event.application.port.out.CreateEventOutputPort;
import com.example.sketch2.event.application.port.out.LoadEventGoodsOrderOutputPort;
import com.example.sketch2.event.domain.EventGoodsOrder;
import com.example.sketch2.event.domain.OnlineEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class CreateEventService implements CreateEventUseCase {
    private LoadEventGoodsOrderOutputPort loadEventGoodsOrderOutputPort;
    private CreateEventOutputPort createEventOutputPort;


    @Override
    public void create(CreateEventRequest request) {
        List<EventGoodsOrder> orders = loadEventGoodsOrderOutputPort.loadOrders();
        List<OnlineEvent> events = getMapToOnlineEvents(request, orders);
        if (events.isEmpty()) {
            return;
        }

    }

    private List<OnlineEvent> getMapToOnlineEvents(final CreateEventRequest request, final List<EventGoodsOrder> orders) {
        return orders
                .stream()
                .map(order -> createEvent(request, order))
                .toList();
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
