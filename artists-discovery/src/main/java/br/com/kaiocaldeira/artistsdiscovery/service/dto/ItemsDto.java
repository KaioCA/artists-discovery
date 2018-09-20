package br.com.kaiocaldeira.artistsdiscovery.service.dto;

import java.util.List;

public class ItemsDto {

    private String name;

    private List<String> genres;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
