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

@WebServlet("/user/homepage")
public class UserDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/userpage.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String weigh = req.getParameter("weigh");
        final String height = req.getParameter("height");
        final String percentOfFat = req.getParameter("percentOfFat");
        final String percentOfMuscle = req.getParameter("percentOfMuscle");

        UserData userData=new UserData();
        userData.setHeight(Double.parseDouble(height));
        userData.setWeigh(Double.parseDouble(weigh));
        userData.setPercentOfFat(Double.parseDouble(percentOfFat));
        userData.setPercentOfMuscle(Double.parseDouble(percentOfMuscle));

        UserDataService userDataService= new UserDataService();
        User user = (User) req.getSession().getAttribute("user");
        userData.setUser_id(user.getId());
        userDataService.addData(userData);
        resp.sendRedirect("/user/homepage");

    }

}
