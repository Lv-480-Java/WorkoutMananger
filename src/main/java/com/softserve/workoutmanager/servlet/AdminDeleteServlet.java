package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete-user")
public class AdminDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminService adminService=new AdminService();
        final Long id = Long.valueOf(request.getParameter("id"));
        adminService.removeUser(id);

        response.sendRedirect("/admin/homepage");
    }
}
