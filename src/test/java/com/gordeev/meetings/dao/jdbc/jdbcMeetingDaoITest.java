package com.gordeev.meetings.dao.jdbc;

import com.gordeev.meetings.entity.Meeting;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class jdbcMeetingDaoITest {
    @Test
    public void testGetAll(){
        JdbcMeetingDao jdbcMeetingDao = new JdbcMeetingDao();
        List<Meeting> meetings = jdbcMeetingDao.getAll();

        assertFalse(meetings.isEmpty());
        for (Meeting meeting : meetings) {
            assertNotNull(meeting.getName());
            assertNotNull(meeting.getFirstName());
            assertNotNull(meeting.getLastName());
            assertNotNull(meeting.getDateFrom());
            assertNotNull(meeting.getDateTo());
        }
    }
}