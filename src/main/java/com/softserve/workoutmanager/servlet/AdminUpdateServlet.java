package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update-user")
public class AdminUpdateServlet extends HttpServlet {

    AdminService adminService=new AdminService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final Long id = Long.valueOf(req.getParameter("id"));

        final User user = adminService.readByid(id);

        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/adminupdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        final String email = req.getParameter("email");
        final String phone = req.getParameter("phone");

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);


        final Long id = Long.valueOf(req.getParameter("id"));

        adminService.update(user, id);

        resp.sendRedirect("/admin/homepage");
    }
}
