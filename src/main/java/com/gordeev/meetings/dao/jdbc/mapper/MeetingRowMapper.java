package com.gordeev.meetings.dao.jdbc.mapper;

import com.gordeev.meetings.entity.Meeting;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MeetingRowMapper {
    public Meeting mapRow(ResultSet resultSet) throws SQLException {
        Meeting meeting = new Meeting();

        meeting.setId(resultSet.getLong("id"));
        meeting.setName(resultSet.getString("name"));
        meeting.setFirstName(resultSet.getString("firstName"));
        meeting.setLastName(resultSet.getString("lastName"));

        Timestamp dateFromTimestamp = resultSet.getTimestamp("dateFrom");
        LocalDateTime dateFrom = dateFromTimestamp.toLocalDateTime();
        meeting.setDateFrom(dateFrom);

        Timestamp dateToTimestamp = resultSet.getTimestamp("dateTo");
        LocalDateTime dateTo = dateToTimestamp.toLocalDateTime();
        meeting.setDateTo(dateTo);
        
        meeting.setRoom(resultSet.getString("room"));

        return meeting;
    }
}
