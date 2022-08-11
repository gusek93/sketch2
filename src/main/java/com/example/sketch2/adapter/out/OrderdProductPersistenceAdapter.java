package com.example.sketch2.adapter.out;

import com.example.sketch2.application.out.ReadOrderProductPort;
import com.example.sketch2.domain.OrderedProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class OrderdProductPersistenceAdapter implements ReadOrderProductPort {
    @Override
    public List<OrderedProduct> listBy(long goodsNo) {
        return null;
    }
}
