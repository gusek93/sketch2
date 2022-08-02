package com.example.sketch2.event.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class EventGoodsOrder {
    private final Long orderNo;
    private final Long orderUserNo;
    private final Long goodsNo;
}
