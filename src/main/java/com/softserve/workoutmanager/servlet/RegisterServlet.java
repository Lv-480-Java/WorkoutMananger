package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");
        final String passwordRepeat = req.getParameter("password-repeat");
        final String phone = req.getParameter("phone");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        UserService userService = new UserService();

        try {
            userService.registerUser(user, passwordRepeat);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mainpage.jsp");
            req.setAttribute("msg", "Registration successful");
            rd.include(req, resp);

        } catch (IllegalArgumentException e) {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/register.jsp");
            req.setAttribute("msg", e.getMessage());
            rd.include(req, resp);

        }


    }
}
