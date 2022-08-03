package com.example.sketch2.event.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class OnlineEvent {
    private final Long orderNo;
    private final Long goodsNo;
    private final Long userNo;
    private final LocalDateTime endAt;
    private final LocalDateTime updateEndAt;
}
