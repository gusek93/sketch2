package com.example.sketch2.event.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateProductServiceTest {
    private CreateProductService sut;
    private CreateProductPortMock createProductPortMock;

    @BeforeEach
    void setUp() {
        sut = new CreateProductService(createProductPortMock);
    }

    @Test
    void create() {
    }
}