package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.services.LoginService;
import org.cbo.apiservlet.webapp.headers.services.LoginServiceImp;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService auth = new LoginServiceImp();
        Optional<String> username = auth.getUsername(request);
        if(username.isPresent()){
            Cookie usernameCookie = new Cookie("username" , "");
            usernameCookie.setMaxAge(0);
            response.addCookie(usernameCookie);
        }
        response.sendRedirect(request.getContextPath() + "/login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
