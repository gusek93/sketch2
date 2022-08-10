package com.example.sketch2.application.in;

import java.time.LocalDateTime;

public record FanMeetingResponse (
        long orderNo,
        long productNo,
        long userNo,
        String userName,
        String birth,
        String telephone,
        String channel,
        String channelInfo,
        LocalDateTime fanMeetingEndAt,
        boolean updatable,
        LocalDateTime modifiableDeadline
){
}
