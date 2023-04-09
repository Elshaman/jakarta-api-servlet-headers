package org.cbo.apiservlet.webapp.headers.services;

import org.cbo.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductoService {


    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L , "shaman" , "juguetes" , 175000),
                             new Producto(1L , "merak" , "juguetes" , 177000),
                             new Producto(1L , "no-shion" , "juguetes" , 187000)
                );
    }
}
