package com.example.sketch2.application.out;

import com.example.sketch2.domain.OrderedProduct;

import java.util.List;

public interface ReadOrderGoodsPort {
    List<OrderedProduct> listBy(final long goodsNo);
}
