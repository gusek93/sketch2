package com.example.sketch2.event.adapter.in;

import com.example.sketch2.event.application.port.in.CreateProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final CreateProductUseCase createProductUseCase;

    @MutationMapping
    MutationResult createProduct(@Argument long productNo, @Argument String createProductAt) {
        return MutationResult.ok();
    }

}
