package com.example.sketch2.application.in;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CreateFanMeetingRequestTest {
    @Test
    void of() {
        final var request = CreateFanMeetingRequest.of(1L, "2022-12-25 12:34:56");

        assertThat(request.getEventEndAt()).isEqualTo(LocalDateTime.of(2022, 12, 25, 12, 34, 56));
    }
}
