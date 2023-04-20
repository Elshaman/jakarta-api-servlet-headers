package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.services.LoginService;
import org.cbo.apiservlet.webapp.headers.services.LoginServiceCookieImp;
import org.cbo.apiservlet.webapp.headers.services.LoginServiceSessionImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = {"/login" , "/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginService auth = new LoginServiceSessionImp();
        Optional<String> usernameOptional = auth.getUsername(request);

        if(usernameOptional.isPresent()){
            response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = response.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Hola " +  usernameOptional.get() +  "ya has iniciado sesion anteriormente</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Hola" +  usernameOptional.get() +  "has iniciado sesion </h1>");
                out.println("        <p><a href='" + request.getContextPath() + "/index.html'>volver</a></p>");
                out.println("        <p><a href='" + request.getContextPath() + "/logout'>Cerrrar sesion</a></p>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " , " + password);
        if(USERNAME.equals( username ) && PASSWORD.equals(password)){

            HttpSession session = request.getSession();
            session.setAttribute("username" , username);

            //response.addCookie(usernameCookie);
            //response.sendRedirect(request.getContextPath() + "/login.html");
        }else {
            response.sendError( HttpServletResponse.SC_UNAUTHORIZED , "ingreso no authorizado");
        }
    }
}
