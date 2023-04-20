package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.models.Producto;
import org.cbo.apiservlet.webapp.headers.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ProductoServlet", value = {"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImp();
        List<Producto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImp();
        Optional<String> usernameOptional = auth.getUsername(request);

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Listado de productos</title>");
            out.println("    </head>");
            out.println("    <body>");
            if(usernameOptional.isPresent()){
                out.println("    <div style='color:blue'> hola " + usernameOptional.get() +  "</div>");
            }

            out.println("        <h1>listado de productos!</h1>");
            out.println("           <table>");
            out.println("               <tr>");
            out.println("                   <th>id </th>");
            out.println("                   <th>nombre </th>");
            out.println("                   <th>tipo </th>");
            if(usernameOptional.isPresent()){
                out.println("                   <th>precio </th>");
            }

            out.println("               </tr>");
            productos.forEach(p -> {
                out.println("               <tr>");
                out.println("                   <td>" + p.getId() + "</td>");
                out.println("                   <td>" + p.getNombre() + "</td>");
                out.println("                   <td>" + p.getTipo() + "</td>");
                if(usernameOptional.isPresent()) {
                    out.println("                   <td>" + p.getPrecio() + "</td>");
                }
                out.println("               </tr>");
            });
            out.println("           </table>");

            out.println("    </body>");
            out.println("</html>");


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
