package com.example.sketch2.event.application.port.out;

import com.example.sketch2.event.domain.EventGoodsOrder;

import java.util.List;

public interface LoadEventGoodsOrderOutputPort {
    List<EventGoodsOrder> loadOrders();
}
