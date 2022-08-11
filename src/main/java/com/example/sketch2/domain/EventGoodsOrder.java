package com.example.sketch2.domain;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode
@RequiredArgsConstructor
public class EventGoodsOrder {
    private final Long orderNo;
    private final Long orderUserNo;
    private final Long goodsNo;
}
