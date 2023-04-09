package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.models.Producto;
import org.cbo.apiservlet.webapp.headers.services.ProductoService;
import org.cbo.apiservlet.webapp.headers.services.ProductoServiceImp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductoXlsServlet", value = {"/productos.xls" , "/productos.html" , "/productos"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductoService service = new ProductoServiceImp();
        List<Producto> productos = service.listar();

        response.setContentType("text/html;charset=UTF-8");
        String servletPath = request.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if(esXls){
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition" , "attachment;filename=productos.xls");
        }

        try(PrintWriter out = response.getWriter()){
            if(!esXls){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("    <head>");
                out.println("        <meta charset=\"UTF-8\">");
                out.println("        <title>Listado de productos</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("        <h1>listado de productos!</h1>");
                out.println("           <p><a href=\"" + request.getContextPath() + "/productos.xls" + "\">Exportar a xls</a></p>");
                out.println("           <p><a href=\"" + request.getContextPath() + "/productos-json" + "\">Exportar a json</a></p>");
            }

            out.println("           <table>");
            out.println("               <tr>");
            out.println("                   <th>id </th>");
            out.println("                   <th>nombre </th>");
            out.println("                   <th>tipo </th>");
            out.println("                   <th>precio </th>");
            out.println("               </tr>");
            productos.forEach( p -> {
                out.println("               <tr>");
                out.println("                   <td>" + p.getId() + "</td>");
                out.println("                   <td>" + p.getNombre() + "</td>");
                out.println("                   <td>" + p.getTipo() + "</td>");
                out.println("                   <td>" + p.getPrecio() + "</td>");
                out.println("               </tr>");
            });
            out.println("           </table>");
            if(!esXls){
                out.println("    </body>");
                out.println("</html>");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
