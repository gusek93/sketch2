package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.application.in.CreateEventUseCase;
import com.example.sketch2.application.out.CreateEventPort;
import com.example.sketch2.application.out.ReadOrderGoodsPort;
import com.example.sketch2.domain.OnlineEvent;
import com.example.sketch2.domain.OrderedGoods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateEventService implements CreateEventUseCase {
    private final ReadOrderGoodsPort readOrderGoodsPort;
    private final CreateEventPort createEventPort;

    @Override
    public void create(final CreateEventRequest request) {
        final List<OrderedGoods> goods = readOrderGoodsPort.listBy(request.getGoodsNo());
        final List<OnlineEvent> events = mapToOnlineEvents(request, goods);
        createEvents(events);
    }

    private List<OnlineEvent> mapToOnlineEvents(final CreateEventRequest request, final List<OrderedGoods> listOfGoods) {
        return listOfGoods
                .stream()
                .map(goods -> createEvent(request, goods))
                .toList();
    }

    private OnlineEvent createEvent(final CreateEventRequest request, final OrderedGoods goods) {
        final var onlineEvent = new OnlineEvent(goods.getOrderNo(), request.getGoodsNo());
        onlineEvent.setUserNo(goods.getOrder().getUserNo());
        onlineEvent.setEventEndAt(request.getEventEndAt());
        onlineEvent.setModifiableDeadline(request.getEventEndAt());
        return onlineEvent;
    }

    private void createEvents(List<OnlineEvent> events) {
        if (events.isEmpty()) return;
        createEventPort.create(events);
    }
}
