package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.Schedule;
import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserData;
import com.softserve.workoutmanager.service.AdminService;
import com.softserve.workoutmanager.service.ScheduleService;
import com.softserve.workoutmanager.service.UserDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/user/myschedule")
public class UserSecondPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        ScheduleService scheduleService=new ScheduleService();
        UserDataService userDataService=new UserDataService();

        List<UserData> dataList=userDataService.getUserData(user.getId());
        List<Schedule> schedulesList=scheduleService.getallUserSchedule(user.getId());

        req.setAttribute("datas",dataList);
        req.setAttribute("schedules",schedulesList);


        req.getRequestDispatcher("/WEB-INF/myschedule.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDataService userDataService=new UserDataService();

        final Long id = Long.valueOf(req.getParameter("id"));

        userDataService.deleteData(id);

        resp.sendRedirect("/user/myschedule");

    }
}
