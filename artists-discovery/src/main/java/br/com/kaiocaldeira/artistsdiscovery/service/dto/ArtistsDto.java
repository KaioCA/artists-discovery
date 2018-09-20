package br.com.kaiocaldeira.artistsdiscovery.service.dto;

import java.util.List;

public class ArtistsDto {

    private List<ItemsDto> items;

    public List<ItemsDto> getItems() {
        return items;
    }

    public void setItems(List<ItemsDto> items) {
        this.items = items;
    }
}
