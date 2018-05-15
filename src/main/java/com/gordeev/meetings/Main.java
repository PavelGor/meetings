package com.gordeev.meetings;

import com.gordeev.meetings.dao.jdbc.JdbcMeetingDao;
import com.gordeev.meetings.service.MeetingService;
import com.gordeev.meetings.web.servlet.MeetingsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        //config dao
        JdbcMeetingDao jdbcMeetingDao = new JdbcMeetingDao();

        //config services
        MeetingService meetingService = new MeetingService();
        meetingService.setJdbcMeetingDao(jdbcMeetingDao);

        //config servlets
        MeetingsServlet meetingsServlet = new MeetingsServlet();
        meetingsServlet.setMeetingService(meetingService);

        ServletHolder allMeetingsHandler = new ServletHolder(meetingsServlet);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(allMeetingsHandler, "/meetings");

        //config server
        Server server = new Server(8080);
        server.setHandler(handler);

        server.start();
    }
}
