package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/user/deleteschedule")
public class UserScheduleDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleService scheduleService=new ScheduleService();
        final Long id = Long.valueOf(req.getParameter("id"));
        scheduleService.deleteSchedule(id);
        System.out.println(id);
        resp.sendRedirect("/user/myschedule");
    }
}
