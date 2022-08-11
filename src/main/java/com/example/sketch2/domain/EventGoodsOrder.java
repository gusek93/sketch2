package com.example.sketch2.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class EventGoodsOrder {
    private final Long orderNo;
    private final Long orderUserNo;
    private final Long goodsNo;
}
