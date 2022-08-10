package com.example.sketch2.application.in;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateEventRequest {
    private final int goodsNo;
    private final LocalDateTime eventEndAt;

    public CreateEventRequest(int goodsNo, LocalDateTime eventEndAt) {
        this.goodsNo = goodsNo;
        this.eventEndAt = eventEndAt;
    }

    public static CreateEventRequest of(final int goodsNo, final LocalDateTime eventEndAt) {
        return new CreateEventRequest(goodsNo, eventEndAt);
    }

    public static CreateEventRequest of(final int goodsNo, final String eventEndAt) {
        return new CreateEventRequest(goodsNo, LocalDateTime.parse(eventEndAt));
    }
}
