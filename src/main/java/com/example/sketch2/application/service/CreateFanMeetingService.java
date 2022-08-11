package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateFanMeetingRequest;
import com.example.sketch2.application.in.CreateFanMeetingUseCase;
import com.example.sketch2.application.out.CreateFanMeetingPort;
import com.example.sketch2.application.out.ReadOrderGoodsPort;
import com.example.sketch2.domain.FanMeeting;
import com.example.sketch2.domain.OrderStatus;
import com.example.sketch2.domain.OrderedGoods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateFanMeetingService implements CreateFanMeetingUseCase {
    private final ReadOrderGoodsPort readOrderGoodsPort;
    private final CreateFanMeetingPort createFanMeetingPort;

    @Override
    public void create(final CreateFanMeetingRequest request) {
        final List<OrderedGoods> goods = readOrderGoodsPort.listBy(request.getGoodsNo());
        final List<FanMeeting> events = mapToOnlineEvents(request, goods);
        createEvents(events);
    }

    private List<FanMeeting> mapToOnlineEvents(final CreateFanMeetingRequest request, final List<OrderedGoods> products) {
        return products
                .stream()
                .filter(product -> product.getOrder().getStatus() == OrderStatus.COMPLETED)
                .map(product -> createEvent(request, product))
                .toList();
    }

    private FanMeeting createEvent(final CreateFanMeetingRequest request, final OrderedGoods goods) {
        final var onlineEvent = new FanMeeting(goods.getOrderNo(), request.getGoodsNo());
        onlineEvent.setUserNo(goods.getOrder().getUserNo());
        onlineEvent.setEventEndAt(request.getEventEndAt());
        onlineEvent.setModifiableDeadline(request.getEventEndAt());
        return onlineEvent;
    }

    private void createEvents(List<FanMeeting> events) {
        if (events.isEmpty()) return;
        createFanMeetingPort.create(events);
    }
}
