package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " , " + password);
        if(USERNAME.equals( username ) && PASSWORD.equals(password)){
            response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = response.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Login correcto</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Login correcto</h1>");
                out.println("        <h3>Hola " +  username  + " has iniciado con exito</h3>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else {
            response.sendError( HttpServletResponse.SC_UNAUTHORIZED , "ingreso no authorizado");
        }
    }
}
