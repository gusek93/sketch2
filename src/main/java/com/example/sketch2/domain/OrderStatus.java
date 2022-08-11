package com.example.sketch2.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum OrderStatus {
    DELETED("no_qty_delete", "주문 삭제"),
    ORDERED("order", "주문 완료, 재고 차감됨"),
    CANCELLED("payment_cancel", "결제 취소"),
    COMPLETED("payment_end", "결제 완료"),
    UNKNOWN("", "존재하지 않는 값"),
    ;

    private String code;
    private String description;

    OrderStatus(final String code, final String description) {
        this.code = code;
        this.description = description;
    }

    public static OrderStatus fromCode(final String code) {
        return Arrays.stream(values())
                .filter(orderStatus -> orderStatus.code.equals(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
