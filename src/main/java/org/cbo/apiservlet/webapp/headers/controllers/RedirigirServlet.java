package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RedirigirServlet", value = "/dirigible")
public class RedirigirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setHeader("Location" , request.getContextPath() +"/productos" );
        //response.setStatus(HttpServletResponse.SC_FOUND);
        response.sendRedirect(request.getContextPath() +"/productos");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
