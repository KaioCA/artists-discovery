package br.com.kaiocaldeira.artistsdiscovery.service.dto;

import java.util.List;

public class ArtistsDto {

    private String name;

    private List<ItemsDto> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemsDto> getItems() {
        return items;
    }

    public void setItems(List<ItemsDto> items) {
        this.items = items;
    }


}
