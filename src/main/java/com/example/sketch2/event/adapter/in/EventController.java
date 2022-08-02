package com.example.sketch2.event.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
class EventController {

    @MutationMapping
    MutationResult createEvent(@Argument int goodsNo, @Argument String eventEndAt) {
        return MutationResult.ok();
    }
}
