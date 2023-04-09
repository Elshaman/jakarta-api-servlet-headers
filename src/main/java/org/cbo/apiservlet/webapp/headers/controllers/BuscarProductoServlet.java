package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.models.Producto;
import org.cbo.apiservlet.webapp.headers.services.ProductoService;
import org.cbo.apiservlet.webapp.headers.services.ProductoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet(name = "BuscarProductoServlet", value = "/buscar-producto")
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImp();
        String nombre = request.getParameter("producto");
        Optional<Producto> encontrado =  productoService.listar().stream().filter(p-> p.getNombre().contains(nombre)).findFirst();
        if(encontrado.isPresent()){
            response.setContentType("text/html;charset=UTF-8");
            try(PrintWriter out = response.getWriter()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>producto encontrado</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>Producto encontrado " + encontrado.get().getNombre() +"</h1>");
                out.println("    </body>");
                out.println("</html>");
            }
        }else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "producto no hallado");
        }
    }
}
