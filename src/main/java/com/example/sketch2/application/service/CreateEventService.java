package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.application.in.CreateEventUseCase;
import com.example.sketch2.application.out.CreateEventOutPort;
import com.example.sketch2.application.out.LoadEventGoodsOrderOutPort;
import com.example.sketch2.domain.EventGoodsOrder;
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
        final List<EventGoodsOrder> orders = loadEventGoodsOrderOutPort.loadOrders();
        List<OnlineEvent> events = mapToOnlineEvent(request, orders);
        createEvent(events);
    }

    private void createEvent(List<OnlineEvent> events) {
        if (events.isEmpty()) return;
        creatEventOutPort.create(events);
    }

    private List<OnlineEvent> mapToOnlineEvent(final CreateEventRequest request, final List<EventGoodsOrder> orders) {
        return orders.stream()
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
