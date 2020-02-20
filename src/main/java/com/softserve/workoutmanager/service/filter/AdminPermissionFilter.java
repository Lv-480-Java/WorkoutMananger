package com.softserve.workoutmanager.service.filter;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminPermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                if (user.getUserRole().equals(UserRole.ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    res.sendRedirect("/");
                }
            } else {
                res.sendRedirect("/");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
