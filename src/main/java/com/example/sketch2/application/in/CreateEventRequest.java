package com.example.sketch2.application.in;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CreateEventRequest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final long goodsNo;
    private final LocalDateTime eventEndAt;

    public CreateEventRequest(final long goodsNo, final LocalDateTime eventEndAt) {
        this.goodsNo = goodsNo;
        this.eventEndAt = eventEndAt;
    }

    public static CreateEventRequest of(final long goodsNo, final LocalDateTime eventEndAt) {
        return new CreateEventRequest(goodsNo, eventEndAt);
    }

    public static CreateEventRequest of(final long goodsNo, final String eventEndAt) {
        return new CreateEventRequest(goodsNo, LocalDateTime.parse(eventEndAt, DATE_TIME_FORMATTER));
    }
}
