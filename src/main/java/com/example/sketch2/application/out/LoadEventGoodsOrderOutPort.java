package com.example.sketch2.application.out;

import com.example.sketch2.domain.EventGoodsOrder;

import java.util.List;

public interface LoadEventGoodsOrderOutPort {
    List<EventGoodsOrder> loadOrders();
}
