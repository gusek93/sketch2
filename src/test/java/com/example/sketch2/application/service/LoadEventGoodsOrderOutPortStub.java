package com.example.sketch2.application.service;

import com.example.sketch2.application.out.LoadEventGoodsOrderOutPort;
import com.example.sketch2.domain.EventGoodsOrder;

import java.util.List;

public class LoadEventGoodsOrderOutPortStub implements LoadEventGoodsOrderOutPort {
    public List<EventGoodsOrder> loadOrders_will_return = List.of();

    @Override
    public List<EventGoodsOrder> loadOrders() {
        return loadOrders_will_return;
    }
}
