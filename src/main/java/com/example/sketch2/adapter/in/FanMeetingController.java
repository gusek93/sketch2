package com.example.sketch2.adapter.in;

import com.example.sketch2.application.in.CreateFanMeetingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class FanMeetingController {
    private final CreateFanMeetingUseCase createFanMeetingUseCase;

    @MutationMapping
    MutationResult createFanMeeting(@Argument long productNo, @Argument String fanMeetingEndAt) {
        return MutationResult.ok();
    }
}
