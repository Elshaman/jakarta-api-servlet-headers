package org.cbo.apiservlet.webapp.headers.controllers;

import jakarta.mail.FetchProfile;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.cbo.apiservlet.webapp.headers.models.Carro;
import org.cbo.apiservlet.webapp.headers.models.ItemCarro;
import org.cbo.apiservlet.webapp.headers.models.Producto;
import org.cbo.apiservlet.webapp.headers.services.ProductoService;
import org.cbo.apiservlet.webapp.headers.services.ProductoServiceImp;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "AgregarCarroServlet", value = "/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id= Long.parseLong(request.getParameter("id"));
        ProductoService  productoService = new ProductoServiceImp();
        Optional<Producto> producto = productoService.porId(id);
        if(producto.isPresent()){
            ItemCarro item = new ItemCarro(1, producto.get());
            HttpSession session = request.getSession();
            Carro carro;
            if(session.getAttribute("carro") == null){
                carro = new Carro();
                session.setAttribute("carro" , carro);
            }else {
                carro = (Carro) session.getAttribute("carro");
            }
            carro.addITemCarro(item);
        }
        response.sendRedirect(request.getContextPath() + "/ver-carro");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
