package com.example.sketch2.adapter.out;

import com.example.sketch2.domain.OrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderedProduct, OrderedProduct.OrderGoodsId> {
    List<OrderedProduct> findByOptionReferenceProductNo(long optionReferenceProductNo);
}
