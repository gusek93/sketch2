package com.example.sketch2.application.out;

import com.example.sketch2.domain.FanMeeting;

import java.util.List;

public interface CreateFanMeetingPort {

    void create(List<FanMeeting> fanMeeting);
}
