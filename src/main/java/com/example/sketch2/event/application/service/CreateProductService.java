package com.example.sketch2.event.application.service;

import com.example.sketch2.event.application.port.in.CreateProductRequest;
import com.example.sketch2.event.application.port.in.CreateProductUseCase;
import com.example.sketch2.event.application.port.out.CreateProductPort;
import com.example.sketch2.event.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort createProductPort;

    @Override
    public void create(final CreateProductRequest request) {
        final Product product = createProduct(request);
        createProductPort.create(product);
    }

    private Product createProduct(final CreateProductRequest request) {
        final var products = new Product(request.getProductNo(), request.getCreateProductAt());
        return products;
    }
}
