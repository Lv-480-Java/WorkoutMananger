package com.softserve.workoutmanager.service.filter;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/", "/login"})
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) servletRequest;
        final HttpServletResponse res = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();

        if (session != null) {
            final User user = (User) session.getAttribute("user");
            if (user != null) {
                redirectToCorrectUrl(user.getUserRole(), res);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private void redirectToCorrectUrl(UserRole userRole, HttpServletResponse resp) throws IOException {
        switch (userRole) {
            case USER:
                resp.sendRedirect("user/homepage");
                break;
            case ADMIN:
                resp.sendRedirect("admin/homepage");
                break;
            default:
                resp.sendRedirect("user/homepage");
        }
    }

    @Override
    public void destroy() {

    }
}
