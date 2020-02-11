package com.softserve.workoutmanager.servlet;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;
import com.softserve.workoutmanager.service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println(name+" "+password);
        LoginService loginService = new LoginService();

        try {
            User user=loginService.isUserExists(name, password);
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            if (user.getUserRole()==UserRole.USER){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mypage.jsp");
                req.setAttribute("msg", "Logging successful");
                rd.include(req, resp);
            }
            if (user.getUserRole()==UserRole.ADMIN){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/adminpage.jsp");
                req.setAttribute("msg", "Logging successful");
                rd.include(req, resp);
            }


        } catch (IllegalArgumentException e) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/mainpage.jsp");
            req.setAttribute("msg", e.getMessage());
            rd.include(req, resp);
            System.out.println(e);
        }


    }
}
