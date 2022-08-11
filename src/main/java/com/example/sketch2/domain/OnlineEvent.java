package com.example.sketch2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class OnlineEvent {
    private final Long orderNo;
    private final Long goodsNo;
    private final Long userNo;
    private final LocalDateTime endAt;
    private final LocalDateTime updateEndAt;
}
