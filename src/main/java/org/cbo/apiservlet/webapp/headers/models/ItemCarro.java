package org.cbo.apiservlet.webapp.headers.models;

import java.util.Objects;

public class ItemCarro {

    private int Cantidad;
    private Producto producto;

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ItemCarro(int cantidad, Producto producto) {
        Cantidad = cantidad;
        this.producto = producto;
    }

    public int getImporteoTotal(){
        return this.getCantidad() * producto.getPrecio();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarro itemCarro = (ItemCarro) o;
        return Objects.equals(producto.getId(), itemCarro.producto.getId())
                && Objects.equals(producto.getNombre(), itemCarro.producto.getNombre());
    }


}
