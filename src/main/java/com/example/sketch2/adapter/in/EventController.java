package com.example.sketch2.adapter.in;

import com.example.sketch2.application.in.CreateEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final CreateEventUseCase createEventUseCase;

    @MutationMapping
    MutationResult create(@Argument int goodsNo, @Argument String eventEndAt) {
        return MutationResult.ok();
    }
}
