package com.gordeev.meetings.web.servlet;

import com.gordeev.meetings.entity.Meeting;
import com.gordeev.meetings.service.MeetingService;
import com.gordeev.meetings.web.templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingsServlet extends HttpServlet {
    private MeetingService meetingService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> paramMap = new HashMap<>();

        List<Meeting> list = meetingService.getAll();
        paramMap.put("meetings", list);
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("meetings.html", paramMap);

        resp.getWriter().write(page);
    }

    public void setMeetingService(MeetingService meetingService) {
        this.meetingService = meetingService;
    }
}
