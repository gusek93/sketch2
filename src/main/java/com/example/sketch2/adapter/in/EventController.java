package com.example.sketch2.adapter.in;

import org.springframework.stereotype.Controller;

@Controller
public class EventController {
    MutationResult create(int goodsNo, String eventEndAt) {
        return MutationResult.ok();
    }
}
