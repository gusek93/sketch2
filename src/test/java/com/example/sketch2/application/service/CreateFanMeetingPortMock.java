package com.example.sketch2.application.service;

import com.example.sketch2.application.out.CreateFanMeetingPort;
import com.example.sketch2.domain.FanMeeting;

import java.util.List;

public class CreateFanMeetingPortMock implements CreateFanMeetingPort {
    public FanMeeting create_received_argument;
    public List<FanMeeting> create_received_argument_list;
    public boolean create_called;

    @Override
    public void create(final FanMeeting onlineEvent) {
        create_received_argument = onlineEvent;
    }

    @Override
    public void create(List<FanMeeting> onlineEvents) {
        create_called = true;
        create_received_argument_list = onlineEvents;
    }
}