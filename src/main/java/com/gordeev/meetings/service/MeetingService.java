package com.gordeev.meetings.service;

import com.gordeev.meetings.dao.jdbc.JdbcMeetingDao;
import com.gordeev.meetings.entity.Meeting;

import java.util.List;

public class MeetingService {
    private JdbcMeetingDao jdbcMeetingDao;

    public List<Meeting> getAll(){
        return jdbcMeetingDao.getAll();
    }

    public MeetingService() {
    }

    public void setJdbcMeetingDao(JdbcMeetingDao jdbcMeetingDao) {
        this.jdbcMeetingDao = jdbcMeetingDao;
    }
}
