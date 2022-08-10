package com.example.sketch2.application.service;

import com.example.sketch2.application.in.CreateEventRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEventServiceTest {
    private CreateEventService sut;

    @BeforeEach
    void setUp() {
        sut = new CreateEventService();
    }

    @Test
    void create() {
        sut.create(CreateEventRequest.of(1,"2022-12-25 12:34:56"));
        sut.create(CreateEventRequest.of(1, "2022-12-25 12:34:56"));
    }
}