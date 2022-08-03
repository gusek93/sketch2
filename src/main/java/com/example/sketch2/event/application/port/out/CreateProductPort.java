package com.example.sketch2.event.application.port.out;

import com.example.sketch2.event.domain.Product;

public interface CreateProductPort {
    void create(Product product);
}
