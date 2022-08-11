package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateFanMeetingRequest;
import com.example.sketch2.domain.FanMeeting;
import com.example.sketch2.domain.Order;
import com.example.sketch2.domain.OrderStatus;
import com.example.sketch2.domain.OrderedGoods;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateEventServiceTest {
    private final LocalDateTime eventEndAt = LocalDateTime.of(2022, 12, 25, 12, 34, 56);
    private ReadOrderGoodsPortStub readOrderGoodsPort;
    private CreateFanMeetingPortMock createEventPortMock;
    private CreateFanMeetingService sut;

    @BeforeEach
    void setUp() {
        readOrderGoodsPort = new ReadOrderGoodsPortStub();
        createEventPortMock = new CreateFanMeetingPortMock();
        sut = new CreateFanMeetingService(readOrderGoodsPort, createEventPortMock);
    }

    @Test
    @DisplayName("EventGoodsOrder가 있는 경우 기대하는 대로 createEventOutPort create() 호출")
    void create_0() {
        final var request = CreateFanMeetingRequest.of(1, eventEndAt);
        readOrderGoodsPort.listBy_will_return = orderedGoodsListStub();

        sut.create(request);

        assertThat(createEventPortMock.create_received_argument_list.toString())
                .isEqualTo(List.of(expected()).toString());
    }

    @Test
    @DisplayName("EventGoodsOrder가 없는 경우 createEventOutPOrt를 쓰지 않는다")
    void create_1() {
        final var request = CreateFanMeetingRequest.of(1, eventEndAt);
        readOrderGoodsPort.listBy_will_return = List.of();

        sut.create(request);

        assertThat(createEventPortMock.create_called).isFalse();
    }

    private List<OrderedGoods> orderedGoodsListStub() {

        return List.of(createOrderedGoodsStub(100L, OrderStatus.COMPLETED),
                createOrderedGoodsStub(1002L, OrderStatus.CANCELLED));
    }

    private OrderedGoods createOrderedGoodsStub(final long orderNo, final OrderStatus status) {
        final var orderedGoods = new OrderedGoods(orderNo, 1L);
        final Order order = new Order();
        order.setOrderNo(orderNo);
        order.setStatus(status);
        order.setUserNo(1001L);
        orderedGoods.setOrder(order);
        return orderedGoods;
    }

    private FanMeeting expected() {
        final var onlineEvent = new FanMeeting(100L, 1L);
        onlineEvent.setUserNo(1001L);
        onlineEvent.setModifiableDeadline(eventEndAt);
        onlineEvent.setEventEndAt(eventEndAt);
        return onlineEvent;
    }
}