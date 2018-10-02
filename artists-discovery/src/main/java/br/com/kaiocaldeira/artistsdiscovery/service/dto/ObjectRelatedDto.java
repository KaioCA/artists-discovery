package br.com.kaiocaldeira.artistsdiscovery.service.dto;

import java.util.List;

public class ObjectRelatedDto {

    private  List<ArtistsDto> artists;

    public List<ArtistsDto> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistsDto> artists) {
        this.artists = artists;
    }
}
