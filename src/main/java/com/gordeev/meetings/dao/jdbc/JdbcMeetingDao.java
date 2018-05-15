package com.gordeev.meetings.dao.jdbc;

import com.gordeev.meetings.dao.jdbc.mapper.MeetingRowMapper;
import com.gordeev.meetings.entity.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMeetingDao {
    private String GET_ALL_SQL = "SELECT id, name, firstName, lastName, dateFrom, dateTo, room FROM meeting;";

    public List<Meeting> getAll() {
        List<Meeting> meetings = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_SQL);

            MeetingRowMapper meetingRowMapper = new MeetingRowMapper();

            while (resultSet.next()) {
                Meeting meeting = meetingRowMapper.mapRow(resultSet);
                meetings.add(meeting);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return meetings;
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/meetings";
        String user = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
