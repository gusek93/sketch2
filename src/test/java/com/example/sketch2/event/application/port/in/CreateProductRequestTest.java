package com.example.sketch2.event.application.port.in;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CreateProductRequestTest {

    @Test
    void of() {
        final var request = CreateProductRequest.of(1, "2022-12-25 12:34:56");

        assertThat(request.getCreateProductAt()).isEqualTo(LocalDateTime.of(2022, 12, 25, 12, 34, 56));
    }

}