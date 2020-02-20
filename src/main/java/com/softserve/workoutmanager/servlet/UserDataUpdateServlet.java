package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserData;
import com.softserve.workoutmanager.service.UserDataService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/update")
public class UserDataUpdateServlet extends HttpServlet {
    UserDataService userDataService=new UserDataService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id);
        UserData userData=userDataService.getUserDataById(id);

        req.setAttribute("data", userData);

        req.getRequestDispatcher("/WEB-INF/userupdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Double weight = Double.valueOf(req.getParameter("weight"));
        final Double height = Double.valueOf(req.getParameter("height"));
        final Double fat = Double.valueOf(req.getParameter("fat"));
        final Double muscle = Double.valueOf(req.getParameter("muscle"));
        final Long id = Long.valueOf(req.getParameter("id"));

        UserData userData=new UserData();
        userData.setWeigh(weight);
        userData.setWeigh(height);
        userData.setWeigh(fat);
        userData.setWeigh(muscle);

        userDataService.updateUserData(userData,id);

        resp.sendRedirect("/user/myschedule");
    }
}
