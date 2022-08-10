package com.example.sketch2.adapter.in;

import com.example.sketch2.application.in.CreateEventUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final CreateEventUseCase createEventUseCase;

    MutationResult create(int goodsNo, String eventEndAt) {
        return MutationResult.ok();
    }
}
