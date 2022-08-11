package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateFanMeetingRequest;
import com.example.sketch2.application.in.CreateFanMeetingUseCase;
import com.example.sketch2.application.out.CreateFanMeetingPort;
import com.example.sketch2.application.out.ReadOrderGoodsPort;
import com.example.sketch2.domain.FanMeeting;
import com.example.sketch2.domain.OrderStatus;
import com.example.sketch2.domain.OrderedProduct;
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
        final List<OrderedProduct> goods = readOrderGoodsPort.listBy(request.getGoodsNo());
        final List<FanMeeting> fanMeetings = mapToFanMeetings(request, goods);
        createEvents(fanMeetings);
    }

    private List<FanMeeting> mapToFanMeetings(final CreateFanMeetingRequest request, final List<OrderedProduct> products) {
        return products
                .stream()
                .filter(product -> OrderStatus.COMPLETED == product.getOrderStatus())
                .map(product -> createEvent(request, product))
                .toList();
    }

    private FanMeeting createEvent(final CreateFanMeetingRequest request, final OrderedProduct goods) {
        final var onlineEvent = new FanMeeting(goods.getOrderNo(), request.getGoodsNo());
        onlineEvent.setUserNo(goods.getOrder().getUserNo());
        onlineEvent.setEventEndAt(request.getEventEndAt());
        onlineEvent.setModifiableDeadline(request.getEventEndAt());
        return onlineEvent;
    }

    private void createEvents(List<FanMeeting> fanMeetings) {
        if (fanMeetings.isEmpty()) return;
        createFanMeetingPort.create(fanMeetings);
    }
}
