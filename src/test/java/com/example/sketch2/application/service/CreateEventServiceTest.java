package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.domain.EventGoodsOrder;
import com.example.sketch2.domain.OnlineEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CreateEventServiceTest {
    private final LocalDateTime eventEndAt = LocalDateTime.of(2022, 12, 25, 12, 34, 56);
    private LoadEventGoodsOrderOutPortStub loadEventGoodsOrderOutPort;
    private CreateEventOutPortMock createEventOutPort;
    private CreateEventService sut;

    @BeforeEach
    void setUp() {
        loadEventGoodsOrderOutPort = new LoadEventGoodsOrderOutPortStub();
        createEventOutPort = new CreateEventOutPortMock();
        sut = new CreateEventService(loadEventGoodsOrderOutPort
                , createEventOutPort);
    }

    @Test
    @DisplayName("EventGoodsOrder가 있는 경우 기대하는 대로 createEventOutPort create() 호출")
    void create_0() {
        final var request = CreateEventRequest.of(1, eventEndAt);
        loadEventGoodsOrderOutPort.loadOrders_will_return = List.of(new EventGoodsOrder(100L, 100L, 1L));

        sut.create(request);

        assertThat(createEventOutPort.create_received_argument_list)
                .isEqualTo(List.of(expected()));
    }

    @Test
    @DisplayName("EventGoodsOrder가 없는 경우 createEventOutPOrt를 쓰지 않는다")
    void create_1() {
        final var request = CreateEventRequest.of(1, eventEndAt);

        sut.create(request);

        assertThat(createEventOutPort.create_received_argument_list)
                .isEqualTo(List.of());
    }


    private OnlineEvent expected() {
        return new OnlineEvent(
                100L,
                1L,
                100L,
                eventEndAt,
                eventEndAt
        );
    }
}