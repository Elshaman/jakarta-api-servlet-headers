package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name = "CabecerasHttpRequestServlet", value = "/cabeceras-request")
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String metodoHttp = request.getMethod();
        String requestUri = request.getRequestURI();
        String requestUrl = request.getRequestURL().toString();
        String contextPath = request.getContextPath();
        String ServletPath = request.getServletPath();
        String ip= request.getLocalAddr();
        String ipCliente = request.getRemoteAddr();
        int  port= request.getLocalPort();
        String schema = request.getScheme();
        String host = request.getHeader("host");

        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Cabeceras Http Request</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Hola Mundo Servlet!</h1>");
            out.println("           <ul>");
            out.println("               <li>metodo http:" + metodoHttp + "</li>");
            out.println("               <li>uri request:" + requestUri + "</li>");
            out.println("               <li>url reuest:" + requestUrl + "</li>");
            out.println("               <li>Context Path" + contextPath + "</li>");
            out.println("               <li>Servlet Path:" + ServletPath + "</li>");
            out.println("               <li>ip local:" + ip + "</li>");
            out.println("               <li>Puerto local:" + port + "</li>");
            out.println("               <li>Schema:" + schema + "</li>");
            out.println("               <li>Host:" + host + "</li>");
            out.println("               <li>ip cliente:" + ipCliente + "</li>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                out.println("               <li>" + cabecera + ":"  + request.getHeader(cabecera) + "</li>");
            }
            out.println("           </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
