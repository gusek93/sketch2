package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateFanMeetingRequest;
import com.example.sketch2.application.in.CreateFanMeetingUseCase;
import com.example.sketch2.application.out.CreateFanMeetingPort;
import com.example.sketch2.application.out.ReadOrderProductPort;
import com.example.sketch2.domain.FanMeeting;
import com.example.sketch2.domain.OrderStatus;
import com.example.sketch2.domain.OrderedProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateFanMeetingService implements CreateFanMeetingUseCase {
    private final ReadOrderProductPort readOrderProductPort;
    private final CreateFanMeetingPort createFanMeetingPort;

    @Override
    public void create(final CreateFanMeetingRequest request) {
        final List<OrderedProduct> goods = readOrderProductPort.listBy(request.getGoodsNo());
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
        final var fanMeeting = new FanMeeting(goods.getOrderNo(), request.getGoodsNo());
        fanMeeting.setUserNo(goods.getOrder().getUserNo());
        fanMeeting.setEventEndAt(request.getEventEndAt());
        fanMeeting.setModifiableDeadline(request.getEventEndAt());
        return fanMeeting;
    }

    private void createEvents(List<FanMeeting> fanMeetings) {
        if (fanMeetings.isEmpty()) return;
        createFanMeetingPort.create(fanMeetings);
    }
}
