package com.gordeev.meetings.dao.jdbc.mapper;

import com.gordeev.meetings.entity.Meeting;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MeetingRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        //prepare
        MeetingRowMapper meetingRowMapper = new MeetingRowMapper();

        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.getLong("id")).thenReturn(1L);
        when(mockResultSet.getString("name")).thenReturn("test_name");
        when(mockResultSet.getString("lastName")).thenReturn("last_name");
        when(mockResultSet.getString("firstName")).thenReturn("first_name");

        LocalDateTime dateTimeFrom = LocalDateTime.of(2010, Month.AUGUST,10,10,15,20);
        Timestamp dateTimeFromTimestamp = Timestamp.valueOf(dateTimeFrom);
        LocalDateTime dateTimeTo = LocalDateTime.of(2010, Month.AUGUST,10,11,15,20);
        Timestamp dateTimeToTimestamp = Timestamp.valueOf(dateTimeTo);

        when(mockResultSet.getTimestamp("dateFrom")).thenReturn(dateTimeFromTimestamp);
        when(mockResultSet.getTimestamp("dateTo")).thenReturn(dateTimeToTimestamp);
        when(mockResultSet.getString("room")).thenReturn("Haifa");

        //when
        Meeting actual = meetingRowMapper.mapRow(mockResultSet);

        //then
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("test_name", actual.getName());
        assertEquals("first_name", actual.getFirstName());
        assertEquals("last_name", actual.getLastName());
        assertEquals(dateTimeFrom, actual.getDateFrom());
        assertEquals(dateTimeTo, actual.getDateTo());
        assertEquals("Haifa", actual.getRoom());
    }
}