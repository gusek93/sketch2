package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import com.example.sketch2.domain.OnlineEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CreateEventServiceTest {
    private CreateEventOutPortMock createEventOutPort;
    private CreateEventService sut;

    @BeforeEach
    void setUp() {
        createEventOutPort = new CreateEventOutPortMock();
        sut = new CreateEventService(createEventOutPort);
    }

    @Test
    void create() {
        final var request = CreateEventRequest.of(1, "2022-12-25 12:34:56");

        sut.create(request);

        assertThat(createEventOutPort.create_received_argument).isEqualTo(new OnlineEvent(
                null,
                1L,
                null,
                LocalDateTime.of(2022, 12,25,34,56),
                LocalDateTime.of(2022, 12,25,34,56)
        ));
    }
}