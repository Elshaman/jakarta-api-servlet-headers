package org.cbo.apiservlet.webapp.headers.services;

import org.cbo.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImp implements ProductoService {


    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L , "shaman" , "juguetes" , 175000),
                             new Producto(2L , "merak" , "juguetes" , 177000),
                             new Producto(3L , "no-shion" , "juguetes" , 187000)
                );
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream().filter(p-> p.getId().equals(id)).findAny();
    }


}
