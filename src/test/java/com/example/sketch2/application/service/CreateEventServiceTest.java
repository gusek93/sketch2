package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.domain.OnlineEvent;
import com.example.sketch2.domain.Order;
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
    private CreateEventPortMock createEventPortMock;
    private CreateEventService sut;

    @BeforeEach
    void setUp() {
        readOrderGoodsPort = new ReadOrderGoodsPortStub();
        createEventPortMock = new CreateEventPortMock();
        sut = new CreateEventService(readOrderGoodsPort, createEventPortMock);
    }

    @Test
    @DisplayName("EventGoodsOrder가 있는 경우 기대하는 대로 createEventOutPort create() 호출")
    void create_0() {
        final var request = CreateEventRequest.of(1, eventEndAt);
        readOrderGoodsPort.listBy_will_return = orderedGoodsListStub();

        sut.create(request);

        assertThat(createEventPortMock.create_received_argument_list.toString())
                .isEqualTo(List.of(expected()).toString());
    }

    @Test
    @DisplayName("EventGoodsOrder가 없는 경우 createEventOutPOrt를 쓰지 않는다")
    void create_1() {
        final var request = CreateEventRequest.of(1, eventEndAt);
        readOrderGoodsPort.listBy_will_return = List.of();

        sut.create(request);

        assertThat(createEventPortMock.create_called).isFalse();
    }

    private List<OrderedGoods> orderedGoodsListStub() {
        return List.of(createOrderedGoodsStub(100L));
    }

    private OrderedGoods createOrderedGoodsStub(final long orderNo) {
        final var orderedGoods = new OrderedGoods(orderNo, 1L);
        final Order order = new Order();
        order.setOrderNo(orderNo);
        order.setUserNo(1001L);
        orderedGoods.setOrder(order);
        return orderedGoods;
    }

    private OnlineEvent expected() {
        final var onlineEvent = new OnlineEvent(100L, 1L);
        onlineEvent.setUserNo(1001L);
        onlineEvent.setModifiableDeadline(eventEndAt);
        onlineEvent.setEventEndAt(eventEndAt);
        return onlineEvent;
    }
}