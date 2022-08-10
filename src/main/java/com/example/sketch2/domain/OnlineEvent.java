package com.example.sketch2.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@RequiredArgsConstructor
public class OnlineEvent {
    private final Long sellNo;
    private final Long goodsNo;
    private final Long userNo;
    private final LocalDateTime endAt;
    private final LocalDateTime updateEndAt;
}
