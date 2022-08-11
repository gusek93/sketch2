package com.example.sketch2.application.service;

import com.example.sketch2.application.out.ReadOrderGoodsPort;
import com.example.sketch2.domain.OrderedGoods;

import java.util.List;

public class ReadOrderGoodsPortStub implements ReadOrderGoodsPort {
    public List<OrderedGoods> listBy_will_return = List.of();

    @Override
    public List<OrderedGoods> listBy(long goodsNo) {
        return listBy_will_return;
    }
}
