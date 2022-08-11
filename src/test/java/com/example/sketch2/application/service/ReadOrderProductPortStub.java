package com.example.sketch2.application.service;

import com.example.sketch2.application.out.ReadOrderProductPort;
import com.example.sketch2.domain.OrderedProduct;

import java.util.List;

public class ReadOrderProductPortStub implements ReadOrderProductPort {
    public List<OrderedProduct> listBy_will_return = List.of();

    @Override
    public List<OrderedProduct> listBy(long goodsNo) {
        return listBy_will_return;
    }
}
