package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.domain.OnlineEvent;
import org.junit.jupiter.api.BeforeEach;
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
    void create() {
        final var request = CreateEventRequest.of(1, eventEndAt);

        sut.create(request);

        assertThat(createEventOutPort.create_received_argument_list)
                .isEqualTo(List.of(expected()));
    }

    private OnlineEvent expected() {
        return new OnlineEvent(
                null,
                1L,
                null,
                eventEndAt,
                eventEndAt
        );
    }
}