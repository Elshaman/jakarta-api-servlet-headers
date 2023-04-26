package org.cbo.apiservlet.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {

    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public void addITemCarro(ItemCarro item){
       if(items.contains(item)){
           Optional<ItemCarro> optionalItemCarro = items.stream()
                                .filter(i -> i.equals(item))
                                .findAny();
           if(optionalItemCarro.isPresent()){
               ItemCarro i = optionalItemCarro.get();
               i.setCantidad(i.getCantidad() + 1);
           }
       }else{
           this.items.add(item);
       }

    }

    public List<ItemCarro> getItems(){
        return items;
    }


    public int getTotal(){
        return items.stream().mapToInt(ItemCarro::getImporteoTotal).sum();
    }
}

