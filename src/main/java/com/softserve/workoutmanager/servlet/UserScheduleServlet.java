package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.Kind;
import com.softserve.workoutmanager.entity.Schedule;
import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.service.KindService;
import com.softserve.workoutmanager.service.ScheduleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/schedule")
public class UserScheduleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Schedule schedule=new Schedule();

        final String date=req.getParameter("time1")+" "+req.getParameter("time2");
        final String comment=req.getParameter("text");


        User user = (User) req.getSession().getAttribute("user");
        schedule.setUserId(user.getId());
        schedule.setDate(date);
        schedule.setComment(comment);

        ScheduleService scheduleService=new ScheduleService();
        scheduleService.addSchedule(schedule);

        Schedule schedule1=scheduleService.getSchedulebyDate(date);
        long scheduleId=schedule1.getId();
        System.out.println(scheduleId);

        Kind kind=new Kind();
        KindService kindService=new KindService();


        final String cardio=req.getParameter("cardio");
        if (cardio!=null){
            kind.setName("cardio");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String stretching=req.getParameter("stretching");
        if (stretching!=null){
            kind.setName("stretching");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String chest=req.getParameter("chest");
        if (chest!=null){
            kind.setName("chest");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String arms=req.getParameter("arms");
        if (arms!=null){
            kind.setName("arms");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String back=req.getParameter("back");
        if (back!=null){
            kind.setName("back");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String legs=req.getParameter("legs");
        if (legs!=null){
            kind.setName("legs");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }
        final String sholders=req.getParameter("sholders");
        if (sholders!=null){
            kind.setName("sholders");
            kind.setScheduleId(scheduleId);
            kindService.addKind(kind);
        }

        resp.sendRedirect("/user/homepage");
    }
}
