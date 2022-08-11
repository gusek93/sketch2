package com.example.sketch2.application.out;

import com.example.sketch2.domain.OrderedGoods;

import java.util.List;

public interface ReadOrderGoodsPort {
    List<OrderedGoods> listBy(final long goodsNo);
}
