package com.example.sketch2.adapter.out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class OrderProductRepositoryTest {

    @Autowired
    private OrderProductRepository sut;

    @Test
    void findByOptionReferenceProductNo() {
        assertThat(sut.findByOptionReferenceProductNo(1L)).hasSize(2);
    }
}