package com.example.sketch2.event.application.port.in;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateProductRequest {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final long productNo;
    private final LocalDateTime createProductAt;

    public static CreateProductRequest of(final long productNo, final LocalDateTime createProductAt) {
        return new CreateProductRequest(productNo, createProductAt);
    }

    public static CreateProductRequest of(final long productNo, final String createProductAt) {
        return new CreateProductRequest(productNo, LocalDateTime.parse(createProductAt, DATE_TIME_FORMATTER));
    }
}
