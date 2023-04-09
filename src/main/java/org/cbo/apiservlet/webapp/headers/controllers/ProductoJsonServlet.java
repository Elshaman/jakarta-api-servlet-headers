package org.cbo.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.models.Producto;
import org.cbo.apiservlet.webapp.headers.services.ProductoService;
import org.cbo.apiservlet.webapp.headers.services.ProductoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductoJsonServlet", value = "/productos-json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImp();
        List<Producto> productos = productoService.listar();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(productos);
        response.setContentType("application/json");
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream jsonStream = request.getInputStream();
        ObjectMapper objectMapper = new ObjectMapper();
        Producto producto = objectMapper.readValue(jsonStream, Producto.class);
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Detalle de producto</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Detalle de producto!</h1>");
            out.println("           <ul>");
            out.println("               <li>Id:" + producto.getId() +"</li>");
            out.println("               <li>Id:" + producto.getNombre() +"</li>");
            out.println("               <li>Id:" + producto.getTipo() +"</li>");
            out.println("               <li>Id:" + producto.getPrecio() +"</li>");
            out.println("           </ul>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
